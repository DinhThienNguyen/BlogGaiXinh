package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import dto.PostImage;
import services.PostImageService;

@ManagedBean
@ApplicationScoped
public class ImageStreamer {

	private static final String IMAGE_DIRECTORY = System.getProperty("jboss.server.data.dir") + "\\images\\";
	
	@EJB
	PostImageService postImageService;

	public StreamedContent getImage() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();

		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			// So, we're rendering the view. Return a stub StreamedContent so that it will
			// generate right URL.
			return new DefaultStreamedContent();
		} else {
			// So, browser is requesting the image. Get ID value from actual request param.
			String id = context.getExternalContext().getRequestParameterMap().get("imageId");
			PostImage image = postImageService.findById(Integer.valueOf(id));
			return new DefaultStreamedContent(
					new FileInputStream(new File(
							IMAGE_DIRECTORY+ image.getName())),
					"image/jpeg");
		}
	}
}
