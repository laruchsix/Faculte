#include <stdlib.h>
#include <stdio.h> 
#include <string.h> 
#include <assert.h>
#include <fcntl.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h> 
#include <sys/wait.h> 


int main(int argc, char *argv[]){
	assert(argc != 3 );
	
	execv("/bin/ls",argv);

	return EXIT_SUCCESS;
}
