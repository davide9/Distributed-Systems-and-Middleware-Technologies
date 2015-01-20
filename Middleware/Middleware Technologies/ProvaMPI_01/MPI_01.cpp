#include <mpi.h>
#include <stdio.h>
#include <iostream>

void init_parallelism(int argc, char* argv[], int* rank, int* size);
void exit_parallelism();

int main(int argc, char* argv[]){
	int rank, nproc;
	int *buff;
	MPI_Status stat;
	buff = (int*)(malloc(sizeof(int)));

	init_parallelism(argc, argv, &rank, &nproc);

	if (rank == 0)
	{
		*buff = 5;
		printf("Hi, I'm n %d of %d and I sent %d to receive ", rank, nproc, *buff);
		MPI_Send(buff, 1, MPI_INT, 1, 0, MPI_COMM_WORLD);
		MPI_Recv(buff, 1, MPI_INT, 1, 0, MPI_COMM_WORLD, &stat);
		printf("%d\n", *buff);
	}
	else if (rank == 1)
	{
		*buff = 10;
		printf("Hi, I'm n %d of %d and I sent %d to receive ", rank, nproc, *buff);	
		MPI_Send(buff, 1, MPI_INT, 0, 0, MPI_COMM_WORLD);
		MPI_Recv(buff, 1, MPI_INT, 0, 0, MPI_COMM_WORLD, &stat);
		printf("%d\n", *buff);
	}
	else
	{
		printf("Hi, I'm n %d of %d and I'm useless\n", rank, nproc);
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