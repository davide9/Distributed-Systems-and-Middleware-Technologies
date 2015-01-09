#include <mpi.h>
#include <cstdio>

int main(int argc, char* argv[]){
	int rank, nproc;
	MPI_Init(&argc, &argv);
	//ID del thread o processo
	MPI_Comm_rank(MPI_COMM_WORLD, &rank);
	//Numero di thread o processi
	MPI_Comm_size(MPI_COMM_WORLD, &nproc);
	printf("Hi, I'm n %d of %d\n", rank, nproc);
	MPI_Finalize();
	
	return 0;
}