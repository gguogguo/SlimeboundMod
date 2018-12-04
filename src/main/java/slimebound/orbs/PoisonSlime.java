package slimebound.orbs;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.powers.PoisonPower;
import slimebound.vfx.SlimeFlareEffect;


public class PoisonSlime
        extends SpawnedSlime {
    public PoisonSlime() {
        super("PoisonSlime", 2, true, new Color(.58F, .81F, .35F, 1), SlimeFlareEffect.OrbFlareColor.POISON, new Texture("SlimeboundImages/orbs/debuff1.png"), "SlimeboundImages/orbs/poisonous.png");
    }


    public void updateDescription() {
        this.description = this.descriptions[0] + this.passiveAmount + this.descriptions[1];
    }


    public void activateEffectUnique() {


        AbstractMonster mo = AbstractDungeon.getMonsters().getRandomMonster(true);
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(mo, AbstractDungeon.player, new PoisonPower(mo, AbstractDungeon.player, this.passiveAmount), this.passiveAmount, true, AbstractGameAction.AttackEffect.POISON));
    }


    public AbstractOrb makeCopy() {
        return new PoisonSlime();
    }
}


