package com.rfdebug.rfdebug.server.model;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Cached;
import com.googlecode.objectify.annotation.Entity;

@Cached(expirationSeconds = 600)
@Entity
public class VT extends NamedVersionedEntity {

  private Key<AT> atKey;

  // required for objectify
  public VT() {
  };

  public VT(String displayName, String technicalName) {
    super(displayName, technicalName);
  }

  public Key<AT> getAtKey() {
    return atKey;
  }

  public void setAtKey(Key<AT> atKey) {
    this.atKey = atKey;
  }
}
