#include <DHT.h>
#include "DHT.h"
#define DHTPIN 2 //Analog 1
#define DHTTYPE DHT11 
DHT dht(DHTPIN, DHTTYPE);

String estadoSensores = String(); // El estado a enviar de los sensores, se envia a java

String strA0 = String(); // Representacion de los sensores en formato String
String strA1 = String();
String strA2 = String();

String strPin = String(); // Representacion del dispositivo en formato String

// Los pines donde van los componentes
int bombilla1 = 12;
int bombilla2 = 11;
int bombilla3 = 10;

// Los pines donde van los componentes
int sensorLuz0 = A0;
int sensorLuz1 = A1;
int sensorTemp0 = A2;

// Los valores actuales de los componentes
int valorSensorLuz0 = 0;
int valorSensorLuz1 = 0;
float valorSensorTemp0 = 0;

int lec_sensor = 0;

void setup() {
  Serial.begin (9600);
  // Los pines de las bombillas son salida
  pinMode (12, OUTPUT);
  pinMode (11, OUTPUT);
  pinMode (10, OUTPUT);

  Serial.println("listo");
  
}

void loop() {

  // Recogemos el estado de los sensores
  valorSensorLuz0 = analogRead(sensorLuz0);
  valorSensorLuz1 = analogRead(sensorLuz1);
  valorSensorTemp0 = dht.readTemperature();

  // Si de Java llega algo
  if (Serial.available() > 0) {

    // Lee el mensaje java con formato <nombre_dispositivo>:<estado_dispositivo>[*] (ej. 12:1 11:1 10:0)
    String inputJava = Serial.readString();

    int n_pin = inputJava.length()/5;
    
    int i = 0;
    while (i < n_pin) {
      String pin = inputJava.substring(i * 5 + 0, i * 5 + 2);
      String valor = inputJava.substring(i * 5 + 3, i * 5 + 4);

      Serial.print(pin.toInt());
      Serial.print(":");
      Serial.print(valor.toInt());
      Serial.print(" ");
      
      digitalWrite(pin.toInt(), valor.toInt());
      i++;
    }
    Serial.println("");
  }
  Serial.flush();

  if (lec_sensor%4 == 0) {
    strA0 = "A0:" + String(valorSensorLuz0);
    strA1 = " A1:" + String(valorSensorLuz1);
    strA2 = " A2:" + String((int) valorSensorTemp0);
    
    estadoSensores = strA0 + strA1;
    estadoSensores = estadoSensores + strA2;
    Serial.println(estadoSensores);
  }
  lec_sensor++;
  Serial.flush(); 
  delay(500);
}
