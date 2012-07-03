package com.rfdebug.rfdebug.server.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Transient;

import com.googlecode.objectify.annotation.Cached;

@Cached(expirationSeconds = 600)
@Entity
public class AT extends NamedVersionedEntity {

  @Transient
  private List<VT> vts = new ArrayList<VT>();

  // required for objectify
  public AT() {
  };

  public AT(String displayName, String technicalName) {
    super(displayName, technicalName);
  }

  public List<VT> getVts() {
    return vts;
  }

  public void setVts(List<VT> vts) {
    this.vts = vts;
  }
}
