package it.contrader.view;

import it.contrader.controller.Request;

public interface View {

	public void showResults (Request request);

	public void showOptions ();

	public void submit();
}
