int pin = 14;
int unsigned recibido_java[126]; // Lo que llega por USB (java)
int unsigned muestra_tft[8]; // Lo que se muestra en la pantalla tactil
byte unsigned envioa_BT[8]; // Lo que se envia a Bluetooth
byte unsigned recibido_BT; // Lo que se recibe de BLuetooth

void setup() {
  pinMode (13, OUTPUT);
  Serial.begin (9600);
  Serial.flush();

  
  while (!Serial.available()) {
    delay(1000);
    Serial.println("Arduino demanda datos");
    digitalWrite(13, 1);
  }
  
}

void loop() {
  int a = 0;
  while (Serial.available() > 0) {
    delay(80);
    digitalWrite (13, 1);

    recibido_java[a] = Serial.read();
    a++;
    
    
    delay(80);
    digitalWrite(13, 0);
  }
  Serial.print("He recibido:");
  Serial.println(sizeof(recibido_java));
  
}
