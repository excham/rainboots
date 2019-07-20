package net.excham.rainboots.tasks;

import org.bukkit.Color;

import net.excham.rainboots.items.WearableRainboots;

public class RainbootRainbower implements Runnable {
	
	// must be multiple of Pi
	private static final double RESOLUTION = Math.PI * 4; 
	private static final int TICK_MAX = 1000;

	private static final double PI_ONE_THIRD = Math.PI / 3;
	
	private WearableRainboots boots;
	private int tick = 0;

	public RainbootRainbower(WearableRainboots boots) {
		this.boots = boots;
	}
	
	private int doTheMath(int tick, double offset) {		
		return (int) Math.round(Math.abs(Math.sin(tick / RESOLUTION + offset) * 255));
	}
	
	private Color generateColor(int tick) {		
		return Color.fromBGR(
				doTheMath(tick, 0 * PI_ONE_THIRD), 
				doTheMath(tick, 1 * PI_ONE_THIRD), 
				doTheMath(tick, 2 * PI_ONE_THIRD));
	}
	
	public void run() {
		if(!boots.wearerWearing()) return;

		boots.setColor(this.generateColor(this.tick));
		this.tick = ++this.tick % TICK_MAX;
	}

}
