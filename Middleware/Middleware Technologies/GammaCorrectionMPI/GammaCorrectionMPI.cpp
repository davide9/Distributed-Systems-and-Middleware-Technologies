#include <iostream>
#include <stdio.h>
#include <string.h>
#include <math.h>
#include <mpi.h>

int* getGreyMapFromImage(char* path, int* rows, int* cols, int* maxVal);
void createPGMFromMat(char* path, int row, int col, int maxVal, int* mat);
int* applyGammaCorrection(int* mat, int size, double A, double lambda, int maxVal);

void init_parallelism(int argc, char* argv[], int* rank, int* size);
void exit_parallelism();


int main(int argc, char* argv[]){
	int rank, nproc;
	int* mat = NULL;
	int row, col, maxVal;
	int size, correction;

	init_parallelism(argc, argv, &rank, &nproc);
	if (rank == 0){
		mat = getGreyMapFromImage("image.pgm", &row, &col, &maxVal);
		size = row * col;
		int buff[2];

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

		buff[0] = size;
		buff[1] = maxVal;
		
		int* superMat = (int*)(malloc(sizeof(int)*size));
		memcpy(superMat, mat, (size - correction)* sizeof(int));
		delete mat;
		mat = superMat;

		for (int i = 1; i < nproc; i++){
			MPI_Send(buff, 2, MPI_INT, i, 0, MPI_COMM_WORLD);
		}
	}
	else
	{
		int buff[2];
		MPI_Status stat;
		MPI_Recv(buff, 2, MPI_INT, 0, 0, MPI_COMM_WORLD, &stat);
		size = buff[0];
		maxVal = buff[1];
	}
	int *cmp = (int*)(malloc(sizeof(int) * size/nproc));
	MPI_Scatter(mat, size / nproc, MPI_INT, cmp, size / nproc, MPI_INT, 0, MPI_COMM_WORLD);
	
	cmp = applyGammaCorrection(cmp, size/nproc, 1, 2, maxVal);
	
	MPI_Gather(cmp, size / nproc, MPI_INT, mat, size / nproc, MPI_INT, 0, MPI_COMM_WORLD);

	if (rank == 0)
		createPGMFromMat("out.pgm", row, col, maxVal, mat);

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

int* applyGammaCorrection(int* mat, int size, double A, double lambda, int maxVal){
	double correction;

	int* out = (int*)(malloc(sizeof(int)*size));

	for (int i = 0; i < size; i++){
		correction = maxVal * pow((double)mat[i] / maxVal, lambda) * A;
		if (correction > maxVal)
			correction = maxVal;
		out[i] = (int)correction;
	}

	return out;
}

void createPGMFromMat(char* path, int row, int col, int maxVal, int* mat){

	FILE *p_file;

	fopen_s(&p_file, path, "w");
	if (p_file){

		fprintf_s(p_file, "P2\n");
		fprintf_s(p_file, "%d %d\n", col, row);
		fprintf_s(p_file, "%d\n", maxVal);

		int i = 0;
		for (int c = 0; c < col; c++){
			for (int r = 0; r < row; r++){
				fprintf_s(p_file, "%d ", mat[i++]);
			}
		}

		fclose(p_file);
	}
}

int* getGreyMapFromImage(char* path, int* rows, int* cols, int* maxVal){
	char confBuff[20];
	unsigned char *imgBuff;

	FILE *p_file;

	int row = 0, col = 0;//col row <- order in pgm files
	int maxBright = 0;
	int *mat = NULL;

	fopen_s(&p_file, path, "r");
	if (p_file){
		//Test if is binary portable graymap P5
		if (fgets(confBuff, 5, p_file)){
			if (strcmp(confBuff, "P5\n"))
			{
				fclose(p_file);
				return NULL;
			}
		}
		//Get image dimension
		if (fgets(confBuff, 20, p_file)){
			int i = 0;
			while (confBuff[i] != ' ')
			{
				col = col * 10 + (confBuff[i] - 48);
				i++;
				if (col <= 0)
				{
					fclose(p_file);
					return NULL;
				}
			}
			i++;
			while (confBuff[i] != '\n')
			{
				row = row * 10 + (confBuff[i] - 48);
				i++;
				if (row <= 0)
				{
					fclose(p_file);
					return NULL;
				}
			}
		}
		//Get max Brightness
		if (fgets(confBuff, 5, p_file)){
			int i = 0;
			while (confBuff[i] != '\n')
			{
				maxBright = maxBright * 10 + (confBuff[i] - 48);
				i++;
				if (maxBright <= 0)
				{
					fclose(p_file);
					return NULL;
				}
			}
			if (maxBright > 255)
			{
				fclose(p_file);
				return NULL;
			}
		}
		imgBuff = (unsigned char*)(malloc(sizeof(unsigned char)*row*col));
		if (fgets((char*)imgBuff, row*col, p_file)){
			int r, c;
			mat = (int*)(malloc(sizeof(int)*row*col));
			for (r = 0; r < row; r++){
				for (c = 0; c < col; c++){
					//printf("%d%s", (unsigned int)imgBuff[c*row + r], ((unsigned int)imgBuff[c*row + r] < 10 ? "   " : ((unsigned int)imgBuff[c*row + r] < 100 ? "  " : " ")));
					mat[c*row + r] = imgBuff[c*row + r];
				}
				//printf("\n");
			}
		}
		fclose(p_file);
	}
	*rows = row;
	*cols = col;
	*maxVal = maxBright;
	return mat;
}