package dev.main.entity;

import dev.main.Handler;

public abstract class StaticEntity extends Entity {
	
	public StaticEntity(Handler handler,float x,float y,int width,int height,int activity){
		super(handler,x,y,width,height,activity);
	}

}
