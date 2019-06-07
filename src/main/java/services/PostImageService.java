package services;

import java.io.IOException;
import java.util.Objects;

import javax.ejb.Stateless;

import post.PostImage;
import post.PostImageEntity;
import ultilities.GenericService;

@Stateless
public class PostImageService extends GenericService<PostImageEntity, PostImage> {

	public PostImageService() {
		super(PostImageEntity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public PostImageEntity toEntity(PostImage bom) {
		if (Objects.isNull(bom)) {
			return null;
		}
		return new PostImageEntity(bom.getId(), bom.getPath());
	}

	@Override
	public PostImage toBom(PostImageEntity entity) {
		if (Objects.isNull(entity)) {
			return null;
		}
		return new PostImage(entity.getId(), entity.getPath());
	}

	@Override
	public PostImage findById(Integer id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public PostImageEntity save(PostImageEntity entity) {
		// TODO Auto-generated method stub
		return super.save(entity);
	}
	
	@Override
	public PostImage getLatestEntityId() {
		// TODO Auto-generated method stub
		return super.getLatestEntityId();
	}

}
