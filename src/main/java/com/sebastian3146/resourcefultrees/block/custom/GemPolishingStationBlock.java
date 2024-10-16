/* package com.sebastian3146.resourcefultrees.block.custom;

import org.jetbrains.annotations.Nullable;

import com.mojang.serialization.MapCodec;
import com.sebastian3146.resourcefultrees.block.entity.GemPolishingStationBlockEntity;
import com.sebastian3146.resourcefultrees.block.entity.RtBlockEntities;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;

public class GemPolishingStationBlock extends BlockWithEntity implements BlockEntityProvider {
  private static final VoxelShape SHAPE = Block.createCuboidShape(0, 0, 0, 0, 0, 0);
  
  public GemPolishingStationBlock(Settings settings) {
    super(settings);
  }

  @Override
  public BlockRenderType getRenderType(BlockState state) {
    return BlockRenderType.MODEL;
  }

  @Nullable
  @Override
  public BlockEntity createBlockEntity(BlockPos position, BlockState state) {
    return new GemPolishingStationBlockEntity(position, state); 
  }

  @Override
  public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
    if (state.getBlock() != newState.getBlock()) {
      BlockEntity blockEntity = world.getBlockEntity(pos);
      if (blockEntity instanceof GemPolishingStationBlockEntity) {
        ItemScatterer.spawn(world, pos, (GemPolishingStationBlockEntity)blockEntity);
        world.updateComparators(pos, this);
      }
    }
  }

  @Override
  public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
    if (!world.isClient) {
      NamedScreenHandlerFactory screenHandlerFactory = ((GemPolishingStationBlockEntity) world.getBlockEntity(pos));
      if (screenHandlerFactory != null) {
        player.openHandledScreen(screenHandlerFactory);
      }
    }
    return ActionResult.SUCCESS;
  }

  @Override
  public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
    return validateTicker(type, RtBlockEntities.GEM_POLISHING_STATION_BLOCK_ENTITY, 
      (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
  }

  @Override
  protected MapCodec<? extends BlockWithEntity> getCodec() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getCodec'");
  }


}
*/
