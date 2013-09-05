package com.example.gameframework;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

public class RenderingThread extends Thread{

	private volatile boolean mIsRunning = true; //명시적 초기화 (default는 false임).
	//volatile로 멀티스레드 비져빌러티 문제 해결.
	private GameView mGameView;
	private SurfaceHolder mSurfaceHolder;
	
	
public RenderingThread(GameView gameView, SurfaceHolder mSurfaceHolder) {
		mGameView= gameView;
		this.mSurfaceHolder = mSurfaceHolder;
	}

	//	public RenderingThread(){
	//		super();	
	//	}
	//그림그리는 일꾼
	@Override
	public void run() {
		
		//한번의 루프가 애니메이션 작가가 한장의 그림을 그린다.
		// deltaTime은 while한번 도는 시간.
		//1.상태를 업데이트 & 그리기
		Canvas canvas = null; //도화지 생설.
		while(mIsRunning){

			//도화지를 정지시키고 그림그리기
			canvas = mSurfaceHolder.lockCanvas();
			
			//update 작업
			mGameView.update();
			
			//present 작업
			mGameView.present(canvas);
			
			//도화지를 떼내서 필름에 갖다붙이기
			mSurfaceHolder.unlockCanvasAndPost(canvas);
			
			Log.d("ldk","RenderingThread");
			
		}
	}
	
	public void setRunning(boolean isRunning){
		//스레드 멈추기위한 함수
		mIsRunning = isRunning;
	}
	
	
	
}
