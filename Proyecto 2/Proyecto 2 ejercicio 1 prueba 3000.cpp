#include <iostream>
#include <conio.h>

using namespace std;

int main(){
	
	//Declaraci�n de variables y constantes
	string const facultades[3]={"Civil     ","Industrial","Sistemas  "};
	string const materias[2]={"Espanol","Matematicas"};
	int f[2]={0,0}; int a[3]={0,0,0}; int matriz[3][3];
	int auxfac=0, auxmat=0;
	string facmayor;
	string matyor; 

	//Encabezado y lectura de la cantidad de estudiantes.
	for (int i=0;i<3;i++){
	cout<<"\n          Informe de facultad"<<endl;
	cout<<"	         "<<facultades[i]<<endl;
		for(int j=0;j<2;j++){
		
	cout<<"\nIngrese el numero de estudiantes de "<<materias[j]<<" ";		//Lectura del numero de estudiantes
	cin>>matriz[i][j]; 
		}
	}
	
	 //Acumuladores para obtener a[3] = total por facultad
	 //							 f[2] = total por materias
	for (int i=0; i<3; i++){
		for (int j=0; j<2; j++){
			a[i] += matriz[i][j];
		}
	}
	for (int i=0; i<3; i++){
		for (int j=0; j<2; j++){
			f[j] += matriz[i][j];
		}
	}
	
	//Facultad con mayor matr�cula
	for (int i=0; i<3; i++){
		if (a[i]>auxfac){
			facmayor=facultades[i];
		}
	}

	//Materias con mayor matricula
	for (int i=0; i<2; i++){
		if (auxmat<f[i]){
			matyor=materias[i];
		}
	}
	
	
	// impresi�n del encabezado 
	cout<<"\n";
	cout<<"             espanol  matematicas  totales por "<<endl;
	cout<<"		     	     	     facultad"<<endl;
	
	//Impresi�n de la matriz y el total por facultad
	for (int i=0; i<3; i++){
		cout<<facultades[i]<<" ";
		for (int j=0; j<2; j++){
			cout<<"      "<<matriz[i][j]; //Matriz
			}
			cout<<"               "<<a[i]; //total por facultad
		cout<<"\n";
	}
	
	//Impresi�n de los totales por materias.
	cout<<"\nTotales  "<<endl;
	cout<<"Por materias";
	for (int i=0; i<2; i++){	
	cout<<"     "<<f[i];
	}		
	
	cout<<"\n\n";
	cout<<"\nLa facultad con mayor cantidad de matriculas es: "<<facmayor<<endl;
	cout<<"\nLas materias con mayor cantidad de matriculas es: "<<matyor<<endl;
	
	
	getch();
	return 0;
}
