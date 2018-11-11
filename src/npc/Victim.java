package npc;

import java.awt.*;

public class Victim {

    private String status;
    private Color statusColor;
    private Rectangle victim;
    private Rectangle victimArea;
    private Color victimColor;

    public Victim(String status, Color statusColor, Rectangle victim, Color victimColor) {
        this.status = status;
        this.statusColor = statusColor;
        this.victim = victim;
        this.victimColor = victimColor;

        victimArea = new Rectangle((int) victim.getX() - 100, (int) victim.getY() - 50, (int) victim.getWidth() + 200, (int) victim.getHeight() + 100);

    }

    public Rectangle getVictimArea() {
        return victimArea;
    }

    public void setVictimArea(Rectangle victimArea) {
        this.victimArea = victimArea;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Color getStatusColor() {
        return statusColor;
    }

    public void setStatusColor(Color statusColor) {
        this.statusColor = statusColor;
    }

    public Rectangle getVictim() {
        return victim;
    }

    public void setVictim(Rectangle victim) {
        this.victim = victim;
    }

    public Color getVictimColor() {
        return victimColor;
    }

    public void setVictimColor(Color victimColor) {
        this.victimColor = victimColor;
    }
}
