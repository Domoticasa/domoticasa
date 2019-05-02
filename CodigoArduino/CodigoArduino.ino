String estadoBombillas = String(); // El nuevo estado a aplicar en las bombillas, enviado por java
String estadoSensores = String(); // El estado a enviar de los sensores, enviar a java

String strA0 = String(); // Representacion de los sensores en formato String
String strA1 = String();

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
}

void loop() {

  // Recogemos el estado de los sensores
  valorSensorLuz0 = analogRead(sensorLuz0);
  valorSensorLuz1 = analogRead(sensorLuz1);
  
  if (Serial.available() > 0) {
    int t = 0;
    
    estadoBombillas = Serial.readString();

    // Paso de String (que es una clase de Arduino a char[])
    int str_len = estadoBombillas.length() + 1;
    char char_dispositivos[str_len];
    estadoBombillas.toCharArray(char_dispositivos, str_len);

    char char_aux[str_len];
    
    while (t < str_len) {
      
      if (char_dispositivos[t]==' ') {
        char char_dispositivo[t];
        
        int j = 0;
        while (j < t) {
          char_dispositivo[j] = char_aux[j];
          j++;
        }
        j = 0;
        
        while (j < sizeof(char_dispositivo)) {
          char char_auxNombre[5];
          
          if (char_dispositivo[j]==':') {
            char char_nombre[j];
            int z = 0;
            while (z < j) {
              char_nombre[z] = char_auxNombre[z];
              z++;
            }
            char char_estado;
            char_estado = char_dispositivo[j+1];

            
            int pin = atoi(char_nombre);
            int estado = atoi(char_estado);
            
          } else {
            char_auxNombre[j] = char_dispositivo[j];
          }
          
          j++;
        }
      } else {
        char_aux[t] = char_dispositivos[t];  
      }
      
      t++;
    }
  }
  Serial.flush();
  
  
  strA0 = "A0:" + String(valorSensorLuz0);
  strA1 = " A1:" + String(valorSensorLuz1);
  estadoSensores = strA0 + strA1;
  Serial.println(estadoSensores);
  
  Serial.flush(); 
  delay(2000);
}
