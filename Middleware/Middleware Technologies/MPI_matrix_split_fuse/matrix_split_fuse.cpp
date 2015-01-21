#include <mpi.h>
#include <stdio.h>
#include <iostream>

void init_parallelism(int argc, char* argv[], int* rank, int* size);
void exit_parallelism();

int main(int argc, char* argv[]){
	int rank, nproc;
	
	init_parallelism(argc, argv, &rank, &nproc);

	MPI_Status stat;
	int* mat = NULL;
	int* recvbuf;

	int size, correction;
	size = 5 * 5;
	if (size%nproc){
		correction = size / nproc;
		correction = nproc * (correction + 1) - size;
	}
	else
		correction = 0;
	if (correction)
	{
		size += correction;
	}
	recvbuf = (int*)(malloc(sizeof(int)*size / nproc));
	if (rank == 0){
		mat = (int*)(malloc(sizeof(int) * size));
		int i;
		for (i = 0; i < size; i++){
			mat[i] = i;
		}
		printf("DECOMPOSITION\n");
	}
	MPI_Scatter(mat, size/nproc, MPI_INT, recvbuf, size/nproc, MPI_INT, 0, MPI_COMM_WORLD);
	
	for (int row = 0; row < (size / nproc); row++){
		recvbuf[row] += rank;
		printf("%d%s", recvbuf[row], (recvbuf[row] < 10 ? "  " : " "));
	}
	printf(" by process %d\n",rank);

	if (rank == 0)
		printf("COMPOSITION\n");

	MPI_Gather(recvbuf, size/nproc, MPI_INT, mat, size/nproc, MPI_INT, 0, MPI_COMM_WORLD);
	if (rank == 0){
		for (int row = 0; row < 5; row++){
			for (int col = 0; col < 5; col++){
				printf("%d%s", mat[5 * col + row], (mat[5 * col + row] < 10 ? "  " : " "));
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