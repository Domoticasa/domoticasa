#include <UTouch.h>
#include <UTouchCD.h>

#include <UTFT_Buttons.h>

#include <memorysaver.h>
#include <UTFT.h>



extern uint8_t SmallFont[];
extern uint8_t BigFont[];

UTFT          myGLCD(ITDB32S,38,39,40,41);

UTouch        myTouch(6,5,4,3,2);

UTFT_Buttons  myButtons(&myGLCD, &myTouch);

#include <SoftwareSerial.h>
SoftwareSerial Serialdigital (10,11); // RX = 10  TX = 11


int pin = 14;
int unsigned recibido_python[126]; // Lo que llega por USB (java)
int unsigned muestra_tft[8]; // Lo que se muestra en la pantalla tactil
byte unsigned envioa_BT[8]; // Lo que se envia a Bluetooth
byte unsigned recibido_BT; // Lo que se recibe de BLuetooth

void setup()
{
  pinMode (13, OUTPUT);
  
  Serial.begin (9600);
  Serialdigital.begin (9600);
  
  Serial.flush();
  Serialdigital.flush();
  
  while (!Serial.available()) // Espera a que Java envie datos iniciales
  {
    delay(80);
    digitalWrite (13,1);
    delay(80);
    digitalWrite(13, 0);
  }
  
  myGLCD.InitLCD();
  myGLCD.clrScr();
  myGLCD.setFont(SmallFont);

  myTouch.InitTouch();
  myTouch.setPrecision(PREC_MEDIUM);
  myButtons.setTextFont(BigFont);
  
  while (pin < 22) // Habilita como salida los pines 14,15,16,17,18,19,20 y 21
  {
    pinMode (pin, OUTPUT);
    pin++;
  }
  pin = 14;
}

void loop()
{
  int but1, but2, but3, but4, but5, but6, but7, but8, pressed_button;
  
  but1 = myButtons.addButton( 15,  15, 60,  50, "1"); 
  but2 = myButtons.addButton( 90,  15, 60,  50, "2"); 
  but3 = myButtons.addButton( 165, 15, 60,  50, "3");
  but4 = myButtons.addButton( 240, 15, 60,  50, "4");
  
  but5 = myButtons.addButton( 15,  80, 60,  50, "5");
  but6 = myButtons.addButton( 90,  80, 60,  50, "6");
  but7 = myButtons.addButton( 165, 80, 60,  50, "7"); 
  but8 = myButtons.addButton( 240, 80, 60,  50, "8"); 
  myButtons.drawButtons();
  
  myGLCD.setColor (VGA_WHITE);
  myGLCD.drawLine (0,170, 319, 170);

  while(1) 
  {
    while ( !Serial.available() && !Serialdigital.available() && !myTouch.dataAvailable()) // Mientras no datos a recibir, parpadea esperando informacion
    {
      delay(80);
      digitalWrite (13,1);
      delay(80);
      digitalWrite(13,0);

    }
    int a = 0;
    while (Serial.available() > 0) // Llega algo de python
     {
         delay (2);
         digitalWrite (13, 1);
         delay (2);
         recibido_python[a] = Serial.read();
         delay (2);
         envioa_BT[a] = recibido_python[a];
         delay (2);
         digitalWrite (pin, recibido_python[a]);
         delay (2);
         Serialdigital.write (envioa_BT[a]);
         delay (2);
         a++;
         pin++;
     }
     a = 0;
     pin = 14;
     Serial.flush();
     
    if (Serialdigital.available() > 0) // Llega algo de BT
     {
       digitalWrite (13,1);
       delay(1);
       recibido_BT = Serialdigital.read();
       delay(1);
       if (recibido_BT == 1)
        {
           for (int i=0;i<8;i++)
           {
             Serialdigital.write (envioa_BT[i]);
             delay(1);
           }
        }
       else
       {
         Serial.write (recibido_BT);
       }
       delay(1);
     }
     
    int i=0;
    for (int z=0; z<=3; z++)
    {  
      if (recibido_python[i] == 1)
      {
        myGLCD.setColor (VGA_GREEN);
        myGLCD.fillCircle( 15+30+(z*75)+20, 15+25+15, 6);
      }
      if (recibido_python[i] == 0)
      {
        myGLCD.setColor (VGA_MAROON);
        myGLCD.fillCircle( 15+30+(z*75)+20, 15+25+15, 6);
      }
      i++;
    }
    for (int z=0; z<=3; z++)
    {
      if (recibido_python[i] == 1)
      {
        myGLCD.setColor (VGA_GREEN);
        myGLCD.fillCircle( 15+30+(z*75)+20, 15+50+15+25+15, 6);
      }
      if (recibido_python[i] == 0)
      {
        myGLCD.setColor (VGA_MAROON);
        myGLCD.fillCircle( 15+30+(z*75)+20, 15+50+15+25+15, 6);
      }
      i++;
    }
    i=0;
    
    if (myTouch.dataAvailable() == true)
     {
       pressed_button = myButtons.checkButtons();

       if (pressed_button==but1 && recibido_python[0] == 1)
         Serial.write (10);
       if (pressed_button==but1 && recibido_python[0] == 0)
         Serial.write (11);
        
       if (pressed_button==but2 && recibido_python[1] == 1)
         Serial.write (20);
       if (pressed_button==but2 && recibido_python[1] == 0)
         Serial.write (21);
        
       if (pressed_button==but3 && recibido_python[2] == 1)
         Serial.write (30);
       if (pressed_button==but3 && recibido_python[2] == 0)
         Serial.write (31);
        
       if (pressed_button==but4 && recibido_python[3] == 1)
         Serial.write (40);
       if (pressed_button==but4 && recibido_python[3] == 0)
         Serial.write (41);
        
       if (pressed_button==but5 && recibido_python[4] == 1)
         Serial.write (50);
       if (pressed_button==but5 && recibido_python[4] == 0)
         Serial.write (51);
        
       if (pressed_button==but6 && recibido_python[5] == 1)
         Serial.write (60);
       if (pressed_button==but6 && recibido_python[5] == 0)
         Serial.write (61);
        
       if (pressed_button==but7 && recibido_python[6] == 1)
         Serial.write (70);
       if (pressed_button==but7 && recibido_python[6] == 0)
         Serial.write (71);
        
       if (pressed_button==but8 && recibido_python[7] == 1)
         Serial.write (80);
       if (pressed_button==but8 && recibido_python[7] == 0)
         Serial.write (81);
        
     }
     Serialdigital.flush();
   }
}
