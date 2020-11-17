#include <stdlib.h>
#include <assert.h>
#include <unistd.h> 
#include <stdio.h>



int main(int argc, char *argv[]){
	assert(argc >= 2);

	for(int i=1; i< (argc); i++){
		printf("%s ", argv[i]);

		execv("./Exo_7_1",(const char*) argv[i]);

		printf("\n");
	}
	return EXIT_SUCCESS;
}
