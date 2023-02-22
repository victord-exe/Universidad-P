//Ejercicio 2 proyecto 2.

#include <iostream>
#include <stdlib.h>
#include <math.h>
using namespace std;

int main(){
	char opcion;
	float a, b, resp, r, h;
	float calcularCirculo(float r);
	float calcularCuadrado(float r);
	float calcularTriangulo(float b, float h);
	float calcularCilindro(float r, float h);
	float base, altura;
	
		cout<<"Escoja una figura para calcular el area"<<endl;
		cout<<" a: Circulo"<<endl;
		cout<<" b: Cuadrado"<<endl;
		cout<<" c: Triangulo"<<endl;
		cout<<" d: Cilindro"<<endl;
		cout<<"\n";		
		
	do{
				
		cout<<"\nIngrese su opcion  "; cin>>opcion;
		if (opcion=='a'){
			cout<<"\nIntroduzca el radio de la circunferencia: ";
			cin>>r;
			resp=calcularCirculo(r);
			cout<<"\nEl area del circulo es: "<<resp<<endl;
			cout<<"\n\n\n";

			}
			
		if (opcion=='b'){
			cout<<"\nDigite un lado del cuadrado ";
			cin>>r;
			resp=calcularCuadrado(r);
			cout<<"\nEl area del cuadrado es: "<<resp;
			cout<<"\n\n\n";
	
			}
			
		if (opcion=='c'){
			cout<<"\nIntroducir el valor de la base: ";
			cin>>b;
			cout<<"Introduzca la altura: ";
			cin>>h;
			resp=calcularTriangulo(b,h);
			cout<<"\nEl area del triangulo es: "<<resp;
			cout<<"\n\n\n";
		
		}
		
		if (opcion=='d'){
			cout<<"\nIntroducir el radio y la altura del cilindro: ";
			cin>>r, h;
			resp=calcularCilindro(r,h);
			cout<<"\nEl area del cilindro es: "<<resp;
			cout<<"\n\n\n";

		}
			if (opcion != 'e'){
			cout<<"Desea calcular otra figura?"<<endl;
			cout<<"Si: Seleccione otra figura"<<endl;
			cout<<"No: presione la letra e"<<endl;
			cout<<"\n";
			cout<<" a: Circulo"<<endl;
			cout<<" b: Cuadrado"<<endl;
			cout<<" c: Triangulo"<<endl;
			cout<<" d: Cilindro"<<endl;
			cout<<"\n";	
			}
		
	}while (opcion!='e');
	
	
	cout<<"\n";
	
	system ("pause");
	return 0;
}
	//Def de función
	
	float calcularCirculo(float r){
		float a;
		a=3.1416*r*r;
		return a;
	}
	
	float calcularCuadrado(float r){
		float a;
		a=pow(r,2);
		return a;
	}
	
	float calcularTriangulo(float base, float altura){
		float a;
		a=(base*altura)/2;
		return a;
	}
	
	float calcularCilindro(float r, float h){
		float a;
		a=(2*3.1416*r)*(r*h);
		return a;
	}
