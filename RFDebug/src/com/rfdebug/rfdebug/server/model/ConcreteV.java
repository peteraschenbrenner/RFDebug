package com.rfdebug.rfdebug.server.model;

import com.googlecode.objectify.annotation.Cached;
import com.googlecode.objectify.annotation.Subclass;

@Cached(expirationSeconds = 600)
@Subclass
public class ConcreteV extends AbstractV {

  private String concreteStuff;

  // required for objectify
  public ConcreteV() {
  };

  public ConcreteV(VT vt, String conreteStuff) {
    super(vt);
    this.concreteStuff = conreteStuff;
  }

  public String getConcreteStuff() {
    return concreteStuff;
  }

  public void setConcreteStuff(String concreteStuff) {
    this.concreteStuff = concreteStuff;
  }
}
