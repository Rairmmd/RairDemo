package com.rairmmd.facedetect;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.rairmmd.facedetect.constant.Constants;
import com.rairmmd.facedetect.utils.DateUtils;
import com.rairmmd.facedetect.view.DrawFaceView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback, Camera.FaceDetectionListener {

    private SurfaceView surfaceView;
    private DrawFaceView faceView;
    private Camera mCamera;
    private boolean safeToTakePicture;
    private static String TAG = "yoju";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        surfaceView = findViewById(R.id.surfaceView);
        faceView = findViewById(R.id.faceView);
        openSurfaceView();
    }

    private void openSurfaceView() {
        SurfaceHolder surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if (mCamera == null) {
            try {
                mCamera = Camera.open(Camera.CameraInfo.CAMERA_FACING_BACK);
                mCamera.setFaceDetectionListener(this);
                mCamera.setPreviewDisplay(holder);
                mCamera.startFaceDetection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            mCamera.stopPreview();
            mCamera.release();
            mCamera = null;
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        try {
            mCamera.stopPreview();
            mCamera.setPreviewDisplay(holder);
            Camera.Parameters parameters = mCamera.getParameters();
            parameters.setJpegQuality(100);
            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            parameters.setPictureSize(640, 480);
            parameters.setPictureFormat(PixelFormat.JPEG);
            parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);
            mCamera.cancelAutoFocus();
            mCamera.setDisplayOrientation(90);
            mCamera.setParameters(parameters);
            mCamera.startPreview();
            mCamera.startFaceDetection();
            safeToTakePicture = true;
        } catch (Exception e) {

        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mCamera.stopPreview();
        mCamera.release();
        mCamera = null;
    }

    @Override
    public void onFaceDetection(Camera.Face[] faces, Camera camera) {
        if (faces.length > 0) {
            Camera.Face face = faces[0];
            Rect rect = face.rect;
            Log.d("FaceDetection", "可信度：" + face.score + "face detected: " + faces.length +
                    " Face 1 Location X: " + rect.centerX() +
                    "Y: " + rect.centerY() + "   " + rect.left + " " + rect.top + " " + rect.right + " " + rect.bottom);
            Matrix matrix = new Matrix();
            Camera.CameraInfo info = new Camera.CameraInfo();
            boolean mirror = (info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT);
            matrix.setScale(mirror ? -1 : 1, 1);
            matrix.postRotate(90);
            matrix.postScale(surfaceView.getWidth() / 2000f, surfaceView.getHeight() / 2000f);
            matrix.postTranslate(surfaceView.getWidth() / 2f, surfaceView.getHeight() / 2f);
            faceView.updateFaces(matrix, faces);
            if (safeToTakePicture) {
                takePhoto();
                safeToTakePicture = false;
            }
        } else {
            faceView.removeRect();
            safeToTakePicture = true;
        }
    }

    private void takePhoto() {
        mCamera.takePicture(null, null, new Camera.PictureCallback() {
            @Override
            public void onPictureTaken(byte[] data, Camera camera) {
                Matrix matrix = new Matrix();
                matrix.postRotate(90);
                Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                String fileName = DateUtils.getNowTime() + ".jpg";
                File file = new File(Constants.FILE_PATH);
                if (!file.exists()) {
                    file.mkdir();
                }
                File bitmapFile = new File(file, fileName);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(bitmapFile);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    fileOutputStream.close();
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                }
                faceDetect(bitmapFile, data);
                bitmap.recycle();
            }
        });
    }

    private void faceDetect(File bitmapFile, final byte[] imgData) {
        Intent intent = new Intent(this, PictureActivity.class);
        intent.putExtra(Constants.PATH_KEY, bitmapFile.getPath());
        startActivity(intent);
    }
}
