package backend;

import com.bastiaanjansen.otp.HMACAlgorithm;
import com.bastiaanjansen.otp.*;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Base64;

public class App {
    private TOTP totpReplic=null;

    public App(){

    }
    //Falta agregar el period al TOTP
    public void changeSeed(String seed){
        TOTP.Builder builder = new TOTP.Builder(Base64.getDecoder().decode(seed))               //Replicamos el TOTP del Encryprot
                .withPeriod(Duration.ofSeconds(30))
                .withPasswordLength(6)
                .withAlgorithm(HMACAlgorithm.SHA1);
        totpReplic = builder.build();
    }

    public String getCode(){
        if (totpReplic==null)
            return("no seed introduced, please input one first");
        return totpReplic.now();
    }



}
