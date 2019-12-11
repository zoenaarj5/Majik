package vm;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

import ao.PeopleAO;
import biz.Person;

public class PeopleController extends GenericForwardComposer<Component>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Person _currentPerson;
	private ListModelList<Person> _model=PeopleAO.getUniqueInstance().getModel();
	Listbox lstPeople;
	Textbox txtUserName,txtEmail,txtFirstName,txtMiddleName,txtLastName,txtBirthDate;
	public ListModel<Person> getPeopleModel() {
		return _model;
	}
	public Person getCurrentPerson() {
		return _currentPerson;
	}
	public void setCurrentPerson(Person p) {
		this._currentPerson=p;
	}
	public void onClick$btnAddPerson() {
		String userName = txtUserName.getText();
		String email = txtEmail.getText();
		String firstName = txtFirstName.getText();
		String middleName = txtMiddleName.getText();
		String lastName = txtLastName.getText();
		String birthDate = txtBirthDate.getText();
		Person p=Person.createPerson(userName, email, firstName, middleName, lastName, birthDate);
		if(!_model.add(p)) {
			System.out.println("PeopleController.0");
		}
	}
	public void onClick$btnUpdatePerson() {
		if(lstPeople.getSelectedItem() != null) {
			Person person = (Person) (lstPeople.getSelectedItem().getValue());
			if(!_model.remove(person)) {
				System.out.println("PeopleController.2");
			}
		}
	}
	public void onClick$btnDeletePerson() {
		if(lstPeople.getSelectedItem() != null) {
			Person person = (Person) (lstPeople.getSelectedItem().getValue());
			if(!_model.remove(person)) {
				System.out.println("PeopleController.3");
			}
		}else {
			System.out.println("PeopleController.4");
		}
	}
}
