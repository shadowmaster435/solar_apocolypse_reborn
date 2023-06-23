package org.shadowmaster435.solar_apocalypse.util;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.joml.Matrix4f;
import org.joml.Vector3f;

public class RenderUtil {

    public static void textured_quad(Identifier identifier, MatrixStack matrixStack, Vector3f pos, float width_x, float width_z) {
        textured_quad(identifier, matrixStack, pos.x, pos.y, pos.z, width_x, width_z);
    }
    public static void textured_colored_quad(Identifier identifier, MatrixStack matrixStack, Vector3f pos, float width_x, float width_z, float r, float g, float b, float a) {
        textured_colored_quad(identifier, matrixStack, pos.x, pos.y, pos.z, width_x, width_z, r, g, b, a);

    }
    public static void textured_quad_no_cull(Identifier identifier, MatrixStack matrixStack, Vector3f pos, float width_x, float width_z) {
        textured_quad_no_cull(identifier, matrixStack, pos.x, pos.y, pos.z, width_x, width_z);

    }
    public static void textured_colored_quad_no_cull(Identifier identifier, MatrixStack matrixStack, Matrix4f mat4, Vector3f pos, float width_x, float width_z, float r, float g, float b, float a) {
        textured_colored_quad_no_cull(identifier, matrixStack, pos.x, pos.y, pos.z, width_x, width_z, r, g, b, a);
    }
    public static void textured_colored_quad_no_cull(Identifier identifier, MatrixStack matrixStack, Vector3f pos, float width_x, float width_z, float r, float g, float b, float a) {
        textured_colored_quad_no_cull(identifier, matrixStack, pos.x, pos.y, pos.z, width_x, width_z, r, g, b, a);
    }
    public static void textured_colored_quad_no_cull(Identifier identifier, Matrix4f mat4, Vector3f pos, float width_x, float width_z, float r, float g, float b, float a) {
        textured_colored_quad_no_cull(identifier, mat4, pos.x, pos.y, pos.z, width_x / 16.0f, width_z / 16.0f, r, g, b, a);
    }
    public static void textured_quad(Identifier identifier, MatrixStack matrixStack, float x, float y, float z, float width_x, float width_z) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder builder = tessellator.getBuffer();
        RenderSystem.enableDepthTest();
        RenderSystem.setShader(GameRenderer::getPositionColorTexLightmapProgram);
        RenderSystem.setShaderTexture(0, identifier);
        builder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR_TEXTURE_LIGHT);
        quad(matrixStack, builder, x, y, z, width_x, width_z);
        tessellator.draw();
        RenderSystem.disableDepthTest();
    }
    public static void textured_colored_quad(Identifier identifier, MatrixStack matrixStack, float x, float y, float z, float width_x, float width_z, float r, float g, float b, float a) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder builder = tessellator.getBuffer();
        RenderSystem.setShader(GameRenderer::getPositionColorTexLightmapProgram);
        RenderSystem.setShaderTexture(0, identifier);
        RenderSystem.enableBlend();
        RenderSystem.enableDepthTest();
        builder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR_TEXTURE_LIGHT);
        quad(matrixStack, builder, x, y, z, width_x, width_z);
        tessellator.draw();
        RenderSystem.disableBlend();
        RenderSystem.disableDepthTest();
    }

    public static void textured_quad_no_cull(Identifier identifier, MatrixStack matrixStack, float x, float y, float z, float width_x, float width_z) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder builder = tessellator.getBuffer();
        RenderSystem.enableDepthTest();
        RenderSystem.disableCull();
        RenderSystem.setShader(GameRenderer::getPositionColorTexLightmapProgram);
        RenderSystem.setShaderTexture(0, identifier);
        builder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR_TEXTURE_LIGHT);
        quad(matrixStack, builder, x, y, z, width_x, width_z);
        tessellator.draw();
        RenderSystem.disableDepthTest();
        RenderSystem.enableCull();
    }
    public static void textured_colored_quad_no_cull(Identifier identifier, Matrix4f mat4, float x, float y, float z, float width_x, float width_z, float r, float g, float b, float a) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder builder = tessellator.getBuffer();
        RenderSystem.setShader(GameRenderer::getPositionColorTexLightmapProgram);
        RenderSystem.setShaderTexture(0, identifier);
        RenderSystem.enableBlend();
        RenderSystem.enableDepthTest();
        RenderSystem.disableCull();
        builder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR_TEXTURE_LIGHT);
        colored_quad(mat4, builder, x, y, z, width_x, width_z, r, g, b, a);
        tessellator.draw();
        RenderSystem.disableBlend();
        RenderSystem.disableDepthTest();
        RenderSystem.enableCull();
    }
    public static void textured_colored_quad_no_cull(Identifier identifier, MatrixStack matrixStack, float x, float y, float z, float width_x, float width_z, float r, float g, float b, float a) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder builder = tessellator.getBuffer();
        RenderSystem.setShader(GameRenderer::getPositionColorTexLightmapProgram);
        RenderSystem.setShaderTexture(0, identifier);
        RenderSystem.enableBlend();
        RenderSystem.enableDepthTest();
        RenderSystem.disableCull();
        builder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR_TEXTURE_LIGHT);
        quad(matrixStack, builder, x, y, z, width_x, width_z);
        tessellator.draw();
        RenderSystem.disableBlend();
        RenderSystem.disableDepthTest();
        RenderSystem.enableCull();
    }
    public static void colored_quad(MatrixStack matrixStack, BufferBuilder builder, float x, float y, float z, float width_x, float width_z, float r, float g, float b, float a) {
        Matrix4f mat4 = matrixStack.peek().getPositionMatrix();
        builder.vertex(mat4, x, y, z).color(r, g, b, a).texture(0,0).light(0,0).next();
        builder.vertex(mat4,x, y, z + width_z).color(r, g, b, a).texture(0,1).light(0,1).next();
        builder.vertex(mat4,x + width_x, y, z + width_z).color(r, g, b, a).texture(1,1).light(1,1).next();
        builder.vertex(mat4,x + width_x, y, z).color(r, g, b, a).texture(1,0).light(1,0).next();
    }
    public static void colored_quad(Matrix4f mat4, BufferBuilder builder, float x, float y, float z, float width_x, float width_z, float r, float g, float b, float a) {
        builder.vertex(mat4, x, y, z).color(r, g, b, a).texture(0,0).light(0,0).next();
        builder.vertex(mat4,x, y, z + width_z).color(r, g, b, a).texture(0,1).light(0,1).next();
        builder.vertex(mat4,x + width_x, y, z + width_z).color(r, g, b, a).texture(1,1).light(1,1).next();
        builder.vertex(mat4,x + width_x, y, z).color(r, g, b, a).texture(1,0).light(1,0).next();
    }

    public static void quad(Matrix4f mat4, BufferBuilder builder, float x, float y, float z, float width_x, float width_z) {
        builder.vertex(mat4, x, y, z).color(1.0f, 1.0f, 1.0f, 1.0f).texture(0,0).light(0,0).next();
        builder.vertex(mat4,x, y, z + width_z).color(1.0f, 1.0f, 1.0f, 1.0f).texture(0,1).light(0,1).next();
        builder.vertex(mat4,x + width_x, y, z + width_z).color(1.0f, 1.0f, 1.0f, 1.0f).texture(1,1).light(1,1).next();
        builder.vertex(mat4,x + width_x, y, z).color(1.0f, 1.0f, 1.0f, 1.0f).texture(1,0).light(1,0).next();
    }
    public static void quad(MatrixStack matrixStack, BufferBuilder builder, float x, float y, float z, float width_x, float width_z) {
        Matrix4f mat4 = matrixStack.peek().getPositionMatrix();
        builder.vertex(mat4, x, y, z).color(1.0f, 1.0f, 1.0f, 1.0f).texture(0,0).light(0,0).next();
        builder.vertex(mat4,x, y, z + width_z).color(1.0f, 1.0f, 1.0f, 1.0f).texture(0,1).light(0,1).next();
        builder.vertex(mat4,x + width_x, y, z + width_z).color(1.0f, 1.0f, 1.0f, 1.0f).texture(1,1).light(1,1).next();
        builder.vertex(mat4,x + width_x, y, z).color(1.0f, 1.0f, 1.0f, 1.0f).texture(1,0).light(1,0).next();
    }
}
