#include <mpi.h>
#include <stdio.h>
#include <iostream>

void init_parallelism(int argc, char* argv[], int* rank, int* size);
void exit_parallelism();

int main(int argc, char* argv[]){
	int rank, nproc;
	
	init_parallelism(argc, argv, &rank, &nproc);

	MPI_Status stat;
	int* mat;
	int recvbuf[10];
	if (rank == 0){
		mat = (int*)(malloc(sizeof(int) * 10 * 10));
		int row, col;
		for (row = 0; row < 10; row++){
			for (col = 0; col < 10; col++){
				mat[10 * col + row] = 10 * col + row;
			}
		}
		printf("DECOMPOSITION\n");
	}
	MPI_Scatter(mat, 10, MPI_INT, recvbuf, 10, MPI_INT, 0, MPI_COMM_WORLD);
	
	for (int row = 0; row < 10; row++){
		recvbuf[row] += rank;
		printf("%d%s", recvbuf[row], (recvbuf[row]<10?"  ":" "));
	}
	printf(" by process %d\n",rank);

	if (rank == 0)
		printf("COMPOSITION\n");

	MPI_Gather(recvbuf, 10, MPI_INT, mat, 10, MPI_INT, 0, MPI_COMM_WORLD);
	if (rank == 0){
		for (int row = 0; row < 10; row++){
			for (int col = 0; col < 10; col++){
				printf("%d%s", mat[10 * col + row], (mat[10 * col + row] < 10 ? "  " : " "));
			}
			printf("\n");
		}
	}
	
	exit_parallelism();

	return 0;
}

void init_parallelism(int argc, char* argv[], int* rank, int* size){
	MPI_Init(&argc, &argv);
	//ID del thread o processo
	MPI_Comm_rank(MPI_COMM_WORLD, rank);
	//Numero di processi
	MPI_Comm_size(MPI_COMM_WORLD, size);
}

void exit_parallelism(){
	MPI_Finalize();
}