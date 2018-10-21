package es.infotickets.android.scann.common;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.util.Log;

import net.sourceforge.zbar.Image;
import net.sourceforge.zbar.ImageScanner;
import net.sourceforge.zbar.Symbol;
import net.sourceforge.zbar.SymbolSet;

import es.infotickets.android.ScannResultAct;

public class CodeScanner implements Camera.AutoFocusCallback, Camera.PreviewCallback {

    private Activity act;
    private Camera cam;
    ImageScanner scanner;
    private boolean doing=false;
    private String contenidoCodigo;

    public CodeScanner(Activity actividad, Camera camera) {
        this.scanner = new ImageScanner();
        this.act=actividad;
        cam= camera;
    }

    @Override
    public void onAutoFocus(boolean b, Camera camera) {

    }

    @Override
    public void onPreviewFrame(byte[] bytes, Camera camera) {
        Camera.Size s = camera.getParameters().getPreviewSize();
        Image img = new Image(s.width, s.height, "Y800");
        img.setData(bytes);

        int r =  scanner.scanImage(img);

        if (r !=0) {
            doing=true;
            /*ha detectado un c�digo qr */
            camera.setPreviewCallback(null);
            //hacerBeep();

            SymbolSet set =   scanner.getResults();
            for (Symbol symbol : set) {
                contenidoCodigo = symbol.getData();
            }
            camera.cancelAutoFocus();
            camera.setPreviewCallback(null);
            Log.d("infotickets",""+contenidoCodigo);

            Intent intent = new Intent(act.getApplicationContext(),ScannResultAct.class);
            intent.putExtra("content",contenidoCodigo);
            act.startActivity(intent);
        }
    }
}
