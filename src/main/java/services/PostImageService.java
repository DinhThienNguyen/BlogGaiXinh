package services;

import javax.ejb.Stateless;

import dto.PostImage;
import entities.PostImageEntity;
import ultilities.GenericService;

@Stateless
public class PostImageService extends GenericService<PostImageEntity, PostImage> {

	public PostImageService() {
		super(PostImageEntity.class);
		// TODO Auto-generated constructor stub
	}

//	@Override
//	public PostImageEntity toEntity(PostImage bom) {
//		if (Objects.isNull(bom)) {
//			return null;
//		}
//		return new PostImageEntity(bom.getId(), bom.getName());
//	}
//
//	@Override
//	public PostImage toBom(PostImageEntity entity) {
//		if (Objects.isNull(entity)) {
//			return null;
//		}
//		return new PostImage(entity.getId(), entity.getName());
//	}

	@Override
	public PostImageEntity findById(Integer id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public PostImageEntity save(PostImageEntity entity) {
		// TODO Auto-generated method stub
		return super.save(entity);
	}

	@Override
	public PostImageEntity getLatestEntityId() {
		// TODO Auto-generated method stub
		return super.getLatestEntityId();
	}

}
