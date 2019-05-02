//String estadoBombillas = String(); // El nuevo estado a aplicar en las bombillas, enviado por java
String estadoSensores = String(); // El estado a enviar de los sensores, enviar a java

String strA0 = String(); // Representacion de los sensores en formato String
String strA1 = String();

String strPin = String(); // Representacion de los dispositivos en formato String

// Los pines donde van los componentes
int bombilla1 = 12;
int bombilla2 = 11;
int bombilla3 = 10;

// Los pines donde van los componentes
int sensorLuz0 = A0;
int sensorLuz1 = A1;

// Los valores actuales de los componentes
int valorSensorLuz0 = 0;
int valorSensorLuz1 = 0;

void setup() {
  Serial.begin (9600);
  // Los pines de las bombillas son salida
  pinMode (12, OUTPUT);
  pinMode (11, OUTPUT);
  pinMode (10, OUTPUT);
}

void loop() {

  // Recogemos el estado de los sensores
  valorSensorLuz0 = analogRead(sensorLuz0);
  valorSensorLuz1 = analogRead(sensorLuz1);

  // Si de Java llega algo
  if (Serial.available() > 0) {

    // Lee el mensaje java con formato <nombre_dispositivo>:<estado_dispositivo>[*] (ej. 12:1 11:1 10:0)
    String estadoBombillas = Serial.readString();

    // Paso de String (que es una clase de Arduino) a char[]
    int str_len = estadoBombillas.length();

    /*
    char char_dispositivos[str_len];
    estadoBombillas.toCharArray(char_dispositivos, str_len);

    char char_aux[str_len - 1];
    
    int t = 0;
    while (t < str_len) {
      
      if (char_dispositivos[t]==' ') {
        char char_dispositivo[t + 1];
        
        int j = 0;
        while (j < t) {
          char_dispositivo[j] = char_aux[j];
          j++;
        }
        j = 0;
        
        while (j < sizeof(char_dispositivo)) {
          
          if (char_dispositivo[j]==':') {
            char char_nombre[j];
            int z = 0;
            while (z < j) {
              char_nombre[z] = char_aux[z];
              z++;
            }
            String str_nombre = String(char_nombre);
            String str_estado = String(char_dispositivo[j+1]);

            String aux = str_nombre + str_estado;
            //Serial.println(str_nombre);
            //digitalWrite(str_nombre.toInt(), str_estado.toInt());
            
          } else {
            char_aux[j] = char_dispositivo[j];
          }
          
          j++;
        }
      } else {
        char_aux[t] = char_dispositivos[t];  
      }
      
      t++;
      
    } */
  }
  Serial.flush();
  
  strA0 = "A0:" + String(valorSensorLuz0);
  strA1 = " A1:" + String(valorSensorLuz1);
  estadoSensores = strA0 + strA1;
  Serial.println(estadoSensores);
  
  Serial.flush(); 
  delay(2000);
}
