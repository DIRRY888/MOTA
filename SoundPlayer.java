import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundPlayer {
      File file;
      AudioInputStream stream;
      AudioFormat format;
      DataLine.Info info;
      Clip clip;
      SoundPlayer(){
    	  
      }
      public void loadSound(String fileName) {
    	  file = new File(fileName);
    	  try {
    		  stream = AudioSystem.getAudioInputStream(file);
    		  
    	  }catch(UnsupportedAudioFileException ex) {
    		  
    	  }catch(IOException ex) {
    		  
    	  }
    	  format = stream.getFormat();
      }
      public void playSound() {
    	  info = new DataLine.Info(Clip.class,format);
    	  try {
    		  clip = (Clip)AudioSystem.getLine(info);
    	  }catch(LineUnavailableException ex) {
    		  
    	  }try {
    		  clip.open(stream);
    	  }catch(LineUnavailableException ex) {
    		  
    	  }catch(IOException ex) {}
    	  clip.start();
      }
}
