package com.pack.adapter;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

import java.util.HashMap;
import java.util.List;

import es.infotickets.android.scann.common.CodeScanner;

public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback{
    private SurfaceHolder Holder=null;
    public Camera camara=null;
    private Boolean soportaAutofocus=false;
    private Activity actividad=null;
    public  Activity act_to_launch=null;
    private List<Camera.Size> mSupportedPreviewSizes;
    private Camera.Size mPreviewSize;
    private int Maxwidth;
    private int Maxheight;
    private Camera.Parameters para;
    private int versionApiTelefono;

    public CameraPreview(Activity actividad) {
        super(actividad);

        this.Holder = getHolder();

        this.Holder.addCallback(this);

        this.actividad= actividad;

        WindowManager wm = (WindowManager)	actividad.getSystemService(Context.WINDOW_SERVICE);

        Maxwidth = wm.getDefaultDisplay().getWidth();

        Maxheight = wm.getDefaultDisplay().getHeight();


    }

    public void surfaceCreated(SurfaceHolder holder) {

        try {

            this.camara= Camera.open(Camera.CameraInfo.CAMERA_FACING_BACK);

            camara.setPreviewDisplay(holder);

            this.para =this.camara.getParameters();

            this.mSupportedPreviewSizes = this.camara.getParameters().getSupportedPreviewSizes();

            mPreviewSize = getOptimalPreviewSize(mSupportedPreviewSizes, Maxwidth, Maxheight);

            setOrientacion();

            para.setPreviewSize(mPreviewSize.width,mPreviewSize.height);

            this.camara.setParameters(para);

            int versionApiTelefono = Build.VERSION.SDK_INT;


            if (para.getFocusMode().equals(Camera.Parameters.FOCUS_MODE_CONTINUOUS_VIDEO) || para.getFocusMode().equals(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE) &&versionApiTelefono>=14 )
            {
                this.soportaAutofocus=true;
            }
            else if(para.getFocusMode().equals(Camera.Parameters.FOCUS_MODE_AUTO) || para.getFocusMode().equals(Camera.Parameters.FOCUS_MODE_MACRO))
            {
                this.soportaAutofocus=true;
            }
            else if (para.getFocusMode().equals(Camera.Parameters.FOCUS_MODE_EDOF) || para.getFocusMode().equals(Camera.Parameters.FOCUS_MODE_FIXED) || para.getFocusMode().equals(Camera.Parameters.FOCUS_MODE_INFINITY))
            {
                this.soportaAutofocus=false;
            }

            if (soportaAutofocus)
            {
                camara.startPreview();
               // new EscanerCodigo(this.actividad, this.camara,true);
            }
            else
            {
                this.camara.startPreview();
               // this.camara.setPreviewCallback(new EscanerCodigo(this.actividad, this.camara, false));
            }

            this.camara.setPreviewCallback(new CodeScanner(actividad,this.camara));
        }
        catch (Exception ex)
        {
            try
            {
                if (this.camara.getParameters().getFocusMode().equals(Camera.Parameters.FOCUS_MODE_EDOF) ||this.camara.getParameters().getFocusMode().equals(Camera.Parameters.FOCUS_MODE_FIXED)||this.camara.getParameters().getFocusMode().equals(Camera.Parameters.FOCUS_MODE_INFINITY))
                {
                    if(para.getSupportedFocusModes().contains(Camera.Parameters.FOCUS_MODE_AUTO) || para.getSupportedFocusModes().contains(Camera.Parameters.FOCUS_MODE_MACRO))
                    {
                        this.soportaAutofocus=true;
                    }
                }
                else if (this.camara.getParameters().getFocusMode().equals(Camera.Parameters.FOCUS_MODE_AUTO) ||this.camara.getParameters().getFocusMode().equals(Camera.Parameters.FOCUS_MODE_MACRO))
                {
                    if (para.getSupportedFocusModes().contains(Camera.Parameters.FOCUS_MODE_CONTINUOUS_VIDEO) || para.getSupportedFocusModes().contains(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE) &&versionApiTelefono>=14 )
                    {
                        this.soportaAutofocus=true;
                    }
                }
                else if (this.camara.getParameters().getFocusMode().equals(Camera.Parameters.FOCUS_MODE_CONTINUOUS_VIDEO) ||this.camara.getParameters().getFocusMode().equals(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE))
                {
                    if (para.getSupportedFocusModes().contains(Camera.Parameters.FOCUS_MODE_EDOF) || para.getSupportedFocusModes().contains(Camera.Parameters.FOCUS_MODE_FIXED) || para.getSupportedFocusModes().contains(Camera.Parameters.FOCUS_MODE_INFINITY))
                    {
                        this.soportaAutofocus=false;
                    }
                }

                if (soportaAutofocus)
                {
                //    this.camara.autoFocus(new EscanerCodigo(this.actividad, this.camara,true));
                    camara.startPreview();
                }
                else
                {
                  //  this.camara.setPreviewCallback(new EscanerCodigo(this.actividad, this.camara, false));
                    this.camara.startPreview();
                }


            }catch(Exception exe)
            {
                this.actividad.onBackPressed();
            }
        }
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    public void surfaceDestroyed(SurfaceHolder holder)
    {
        try
        {
            if (this.camara.getParameters().getFocusMode().equals(Camera.Parameters.FOCUS_MODE_CONTINUOUS_VIDEO) || (this.camara.getParameters().getFocusMode().equals(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE)) || (this.camara.getParameters().getFocusMode().equals(Camera.Parameters.FOCUS_MODE_AUTO)))
                this.camara.cancelAutoFocus();

            this.camara.setPreviewCallback(null);
            this.camara.release();
            this.camara=null;
        }catch (Exception e)
        {

        }
    }

    public void setOrientacion()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO)
        {
            setCameraDisplayOrientation(this.actividad, Camera.CameraInfo.CAMERA_FACING_BACK, this.camara);
        }

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.FROYO)
        {}
    }

    public HashMap<String, Integer> getTamanoPreview()
    {
        WindowManager wm = (WindowManager)	this.actividad.getSystemService(Context.WINDOW_SERVICE);
        Camera.Parameters parametros = this.camara.getParameters();
        HashMap<String, Integer> mapa_max_tamano;
        mapa_max_tamano = new HashMap<String,Integer>();
        final int Maxwidth = wm.getDefaultDisplay().getWidth();
        final int Maxheight = wm.getDefaultDisplay().getHeight();

        overLoop:
        for (Camera.Size iterable_element : parametros.getSupportedPreviewSizes()) {
            if (iterable_element.width== Maxwidth && iterable_element.height==Maxheight)
            {
                mapa_max_tamano.put("Ancho", iterable_element.width);
                mapa_max_tamano.put("Alto", iterable_element.height);
                break overLoop;
            }
        }
        return mapa_max_tamano;
    }


    public  void setCameraDisplayOrientation(Activity activity, int cameraId, android.hardware.Camera camera) {
        android.hardware.Camera.CameraInfo info = new android.hardware.Camera.CameraInfo();
        android.hardware.Camera.getCameraInfo(cameraId, info);
        int rotation = activity.getWindowManager().getDefaultDisplay()
                .getRotation();
        int degrees = 0;
        switch (rotation) {
            case Surface.ROTATION_0: degrees = 0; break;
            case Surface.ROTATION_90: degrees = 90; break;
            case Surface.ROTATION_180: degrees = 180; break;
            case Surface.ROTATION_270: degrees = 270; break;
        }

        int result;
        if (info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
            result = (info.orientation + degrees) % 360;
            result = (360 - result) % 360;  // compensate the mirror
        } else {  // back-facing
            result = (info.orientation - degrees + 360) % 360;
        }
        camera.setDisplayOrientation(result);
    }

    private Camera.Size getOptimalPreviewSize(List<Camera.Size> sizes, int w, int h) {
        final double ASPECT_TOLERANCE = 0.1;
        double targetRatio=(double)h / w;

        if (sizes == null) return null;

        Camera.Size optimalSize = null;
        double minDiff = Double.MAX_VALUE;

        int targetHeight = h;

        for (Camera.Size size : sizes) {
            double ratio = (double) size.width / size.height;
            if (Math.abs(ratio - targetRatio) > ASPECT_TOLERANCE) continue;
            if (Math.abs(size.height - targetHeight) < minDiff) {
                optimalSize = size;
                minDiff = Math.abs(size.height - targetHeight);
            }
        }

        if (optimalSize == null) {
            minDiff = Double.MAX_VALUE;
            for (Camera.Size size : sizes) {
                if (Math.abs(size.height - targetHeight) < minDiff) {
                    optimalSize = size;
                    minDiff = Math.abs(size.height - targetHeight);
                }
            }
        }
        return optimalSize;
    }






}
