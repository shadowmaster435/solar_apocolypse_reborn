package org.shadowmaster435.solar_apocalypse.util;

import com.mojang.blaze3d.platform.TextureUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import org.lwjgl.opengl.GL11;
import org.shadowmaster435.solar_apocalypse.mixin.SpriteAtlasTextureAccessor;

import java.nio.ByteBuffer;


public class ModifiableSpriteAtlasTexture {

    public static byte[] atlas_buffer;

    public NativeImage atlas_image;
    public NativeImage modified_atlas_image;

    private SpriteAtlasTexture spriteAtlasTexture;

    private int gl_id;
    private int atlas_gl_id;

    private final int width;
    private final int height;

    public ModifiableSpriteAtlasTexture(Identifier id) {
        this.gl_id = TextureUtil.generateTextureId();
        this.atlas_gl_id = get_atlas_id(id);
        this.spriteAtlasTexture = get_atlas(id);
        this.height = ((SpriteAtlasTextureAccessor) this.spriteAtlasTexture).getHeight();
        this.width = ((SpriteAtlasTextureAccessor) this.spriteAtlasTexture).getWidth();

    }

    public void read_atlas() {
        try {
            GL11.glGetTexImage(atlas_gl_id, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, ByteBuffer.wrap(atlas_buffer));
            atlas_image = NativeImage.read(atlas_buffer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void write_atlas() {
        Identifier id = PlayerScreenHandler.BLOCK_ATLAS_TEXTURE;
    }

    public ModifiableSpriteAtlasTexture modify_texture(Identifier id, int x, int y, int r, int g, int b, int a) {
        return this;
    }

    public static ModifiableSpriteAtlasTexture modify(Identifier id) {
        return new ModifiableSpriteAtlasTexture(id);
    }

    public SpriteAtlasTexture get_atlas(Identifier id) {
        return MinecraftClient.getInstance().getBakedModelManager().getAtlas(id);
    }
    public int get_atlas_id(Identifier id) {
        return MinecraftClient.getInstance().getBakedModelManager().getAtlas(id).getGlId();
    }

}
