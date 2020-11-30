package com.adrish.birdshooter;

import android.content.Context;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Runnable
{
    private Thread thread;
    private boolean isPlaying;
    private Background background1, background2;

    public GameView(Context context, int screenX, int screenY)
    {
        super(context);

        background1 = new Background(screenX, screenY, getResources());
        background2 = new Background(screenX, screenY, getResources());

        background2.x = screenX;
    }

    @Override
    public void run()
    {
        while(isPlaying)
        {
            update();
            draw();
            sleep();
        }
    }

    public void update()
    {
        background1.x -= 10;
        background2.x -= 10;
    }

    public void draw()
    {

    }

    public void sleep()
    {
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume()
    {
        isPlaying = true;
        thread = new Thread(this);
        thread.start();
    }

    public void pause()
    {
        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
