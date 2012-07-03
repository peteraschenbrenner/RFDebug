package com.rfdebug.rfdebug.server.service;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.QueryResultIterable;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;
import com.googlecode.objectify.util.DAOBase;
import com.rfdebug.rfdebug.server.model.A;
import com.rfdebug.rfdebug.server.model.AT;
import com.rfdebug.rfdebug.server.model.AbstractV;
import com.rfdebug.rfdebug.server.model.ConcreteV;
import com.rfdebug.rfdebug.server.model.VT;

public class EntitiesDAO extends DAOBase {

  // dummy methods to ensure that the entities are loaded
  public void todo(A a) {
  };

  public void todo(AbstractV abstractV) {
  };

  public void todo(ConcreteV concreteV) {
  };

  public static void todo(AT at) {
  }

  public static void todo(VT vt) {
  }

  static {
    ObjectifyService.register(AT.class);
    ObjectifyService.register(VT.class);
    ObjectifyService.register(A.class);
    ObjectifyService.register(AbstractV.class);
    ObjectifyService.register(ConcreteV.class);
  }

  public void resetServerData() {

    // clear existing data
    QueryResultIterable<Key<AT>> keysAt = ofy().query(AT.class).fetchKeys();
    ofy().delete(keysAt);

    QueryResultIterable<Key<VT>> keysVt = ofy().query(VT.class).fetchKeys();
    ofy().delete(keysVt);

    QueryResultIterable<Key<A>> keysA = ofy().query(A.class).fetchKeys();
    ofy().delete(keysA);

    QueryResultIterable<Key<AbstractV>> keysAbstractV = ofy().query(AbstractV.class).fetchKeys();
    ofy().delete(keysAbstractV);

    // create the AT and VT
    AT newAt = new AT("AT", "AT");
    VT newVT = new VT("VT", "VT");
    ArrayList<VT> vts = new ArrayList<VT>();
    vts.add(newVT);
    newAt.setVts(vts);
    ArrayList<AT> ats = new ArrayList<AT>();
    ats.add(newAt);
    putAts(ats);

    // create the A and V
    AbstractV newV = new ConcreteV(newVT, "concrete Stuff");
    ArrayList<AbstractV> vs = new ArrayList<AbstractV>();
    vs.add(newV);
    A newA = new A(newAt, vs);
    ArrayList<A> as = new ArrayList<A>();
    as.add(newA);
    putAs(as);
  }

  public void putAts(List<AT> ats) {

    ofy().put(ats);

    ArrayList<VT> vts = new ArrayList<VT>();

    for (AT at : ats) {

      assert at.getId() != null;

      for (VT vt : at.getVts()) {

        vt.setAtKey(new Key<AT>(AT.class, at.getId()));
        vts.add(vt);
      }
    }
    ofy().put(vts);
  }

  public List<A> putAs(List<A> as) {

    for (A a : as) {

      assert a.getAt() != null;
      assert a.getAt().getId() != null;
      assert a.getVs() != null;

      a.setAtKey(new Key<AT>(AT.class, a.getAt().getId()));

      for (AbstractV abstractV : a.getVs()) {

        assert abstractV.getVt() != null;
        assert abstractV.getVt().getId() != null;

        abstractV.setVtKey(new Key<VT>(VT.class, abstractV.getVt().getId()));
      }

      a.setVKeys(new ArrayList<Key<AbstractV>>(ofy().put(a.getVs()).keySet()));
    }

    ArrayList<A> storedAs = new ArrayList<A>(ofy().put(as).values());
    return storedAs;
  }

  public List<A> loadAllAs() {

    Query<A> queryAllAs = ofy().query(A.class);
    ArrayList<A> loadedAs = new ArrayList<A>();

    for (A a : queryAllAs) {
      a.setAt(ofy().get(a.getAtKey()));

      a.setVs(new ArrayList<AbstractV>(ofy().get(a.getVKeys()).values()));

      for (AbstractV loadedV : a.getVs()) {
        loadedV.setVt(ofy().get(loadedV.getVtKey()));
      }

      loadedAs.add(a);
    }

    return loadedAs;
  }

  public List<A> createAs(List<A> as) {
    List<A> asToReturn = putAs(as);

    return asToReturn;
  }

}
