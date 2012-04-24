package com.example.android.notepad;

import android.app.Application;

public class MyApp extends Application {

	  private VirtualMachine vm;

	  public VirtualMachine getVM(){
	    return vm;
	  }
	  public void setVM(VirtualMachine vm){
	    this.vm = vm;
	  }
}