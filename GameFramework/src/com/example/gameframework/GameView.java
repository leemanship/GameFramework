package com.example.gameframework;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

//surfaceView 상속: 필름
//CallBack 구현: 필름의 상태가 바뀔때 호출되는 인터페이스, 3가지의 필름상태를 정의.
public class GameView extends SurfaceView implements Callback {
	RenderingThread mRenderingThread;

	public GameView(Context context) {
		super(context);
		
		//1.필름과 연필(mHolder)을 만들어서 애니메이션 작가를 고용해서 넘겨줌.
		SurfaceHolder mHolder = getHolder();
		mHolder.addCallback(this);
		mRenderingThread = new RenderingThread(this, mHolder);
		
	}

	// 필름을 카메라에 끼운 상태
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		//2.애니메이션 작가에게 일을 시켜야함.
		mRenderingThread.start();
	}

	//
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		
	}
	
	//5.애니메이션 작가 고용해제 (정지)
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		mRenderingThread.setRunning(false);
	}
	
	
	/**
	 * 개발영역
	 */
	//3.필름의 상태 업데이트
	public void update(){
		
	}
	
	//4.필름에 그림그리기
	public void present(Canvas canvas){
		
	}
}
