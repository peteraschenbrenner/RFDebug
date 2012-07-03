package com.rfdebug.rfdebug.server.model;

import javax.persistence.Transient;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Cached;
import com.googlecode.objectify.annotation.Entity;

@Cached(expirationSeconds = 600)
@Entity
public class VT extends NamedVersionedEntity {

  private Key<AT> atKey;

  @Transient
  private AT referencedAT;
  private Key<AT> referencedATKey;

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

  public AT getReferencedAt() {
    return referencedAT;
  }

  public void setReferencedAt(AT referencedAT) {
    this.referencedAT = referencedAT;
  }

  public Key<AT> getReferencedAtKey() {
    return referencedATKey;
  }

  public void setReferencedAtKey(Key<AT> referencedATKey) {
    this.referencedATKey = referencedATKey;
  }

}
