#include <stdlib.h>
#include <assert.h>
#include <unistd.h> 


int main(int argc, char *argv[]){
	assert(argc != 1 );
	
	execv("/bin/ls",argv);

	return EXIT_SUCCESS;
}
