package com.rfdebug.rfdebug.server.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Cached;
import com.googlecode.objectify.annotation.Entity;

@Cached(expirationSeconds = 600)
@Entity
public class A extends VersionedEntity {

  @Transient
  private AT at;
  private Key<AT> atKey;

  @Transient
  private List<AbstractV> vs = new ArrayList<AbstractV>();
  private List<Key<AbstractV>> vKeys = new ArrayList<Key<AbstractV>>();

  // required for objectify
  public A() {
  };

  public A(AT at) {
    this.at = at;
  }

  public A(AT at, List<AbstractV> vs) {
    this.at = at;
    this.vs = vs;
  }

  public AT getAt() {
    return at;
  }

  public void setAt(AT at) {
    this.at = at;
  }

  public Key<AT> getAtKey() {
    return atKey;
  }

  public void setAtKey(Key<AT> atKey) {
    this.atKey = atKey;
  }

  public List<AbstractV> getVs() {
    return vs;
  }

  public void setVs(List<AbstractV> vs) {
    this.vs = vs;
  }

  public List<Key<AbstractV>> getVKeys() {
    return vKeys;
  }

  public void setVKeys(List<Key<AbstractV>> vKeys) {
    this.vKeys = vKeys;
  }
}
