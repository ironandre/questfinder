package questfinder.jsf.viewlogics;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.primefaces.event.FlowEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.MapModel;

import questfinder.hibernate.daos.User;
import questfinder.tools.ValidationUtils;

@ManagedBean
@ViewScoped
@FacesValidator("addUserWizardValidator")
public class AddUserWizard implements Serializable, Validator{
	private static final long serialVersionUID = 1627346099183139024L;

	private User user;
	
	private boolean skip;
	
	private MapModel mapmodel = new DefaultMapModel();
	
	@PostConstruct
	public void init() {
		setUser(new User());
		System.out.println(getUser());
//		mapmodel.
	}
	
    public String onFlowProcess(FlowEvent event) {
        if(isSkip()) {
            setSkip(false);   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	@Override
	public void validate(FacesContext context, UIComponent uiComp, Object value) throws ValidatorException {
		String compID = uiComp.getClientId();
		
		if(compID.endsWith("email")) {
			if(!ValidationUtils.matchesEmailPattern(value.toString())) {
				throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Keine gültige E-Mail","Z.b. abc@def.com"));
			}
		} else if(compID.endsWith("nick")) {
			// check already taken
		}
	}
}
