package com.rfdebug.rfdebug.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.rfdebug.rfdebug.shared.proxy.AProxy;
import com.rfdebug.rfdebug.shared.proxy.ATProxy;
import com.rfdebug.rfdebug.shared.proxy.AbstractVProxy;
import com.rfdebug.rfdebug.shared.proxy.ConcreteVProxy;
import com.rfdebug.rfdebug.shared.proxy.VTProxy;
import com.rfdebug.rfdebug.shared.service.EntitiesRequestContext;
import com.rfdebug.rfdebug.shared.service.EntityRequestFactory;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class RfDebug implements EntryPoint {

  private EntityRequestFactory requestFactory = GWT.create(EntityRequestFactory.class);

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {

    final Button sendButton = new Button("Go");
    RootPanel.get("sendButtonContainer").add(sendButton);
    sendButton.addClickHandler(new ClickHandler() {

      @Override
      public void onClick(ClickEvent event) {

        EventBus eventBus = new SimpleEventBus();
        EntitiesRequestContext context1 = requestFactory.entitiesRequestContext();
        requestFactory.initialize(eventBus);

        // 1 - reset the date
        context1.resetServerData().fire(new Receiver<Void>() {

          @Override
          public void onSuccess(Void response) {
            // 2 - load all As
            EntitiesRequestContext context2 = requestFactory.entitiesRequestContext();
            context2.loadAllAs().with("at", "vs", "vs.vt", "vs.concreteStuff").fire(
                new Receiver<List<AProxy>>() {

                  @Override
                  public void onSuccess(List<AProxy> response) {
                    // 3 - check if the A is loaded, create a new one and send it to the server
                    AProxy loadedA = response.get(0);
                    ATProxy loadedAt = loadedA.getAt();
                    AbstractVProxy loadedV = loadedA.getVs().get(0);
                    VTProxy loadedVt = loadedV.getVt();

                    EntitiesRequestContext context3 = requestFactory.entitiesRequestContext();

                    AProxy newA = context3.create(AProxy.class);
                    newA.setAt(loadedAt);

                    ConcreteVProxy newConcreteV = context3.create(ConcreteVProxy.class);
                    newConcreteV.setVt(loadedVt);
                    newConcreteV.setConcreteStuff("concrete stuff created on the client");
                    ArrayList<AbstractVProxy> newVs = new ArrayList<AbstractVProxy>();
                    newVs.add(newConcreteV);

                    newA.setVs(newVs);

                    ArrayList<AProxy> newAs = new ArrayList<AProxy>();
                    newAs.add(newA);

                    context3.createAs(newAs).with("at", "vs", "vs.vt", "vs.concreteStuff").fire(
                        new Receiver<List<AProxy>>() {

                          @Override
                          public void onSuccess(List<AProxy> response) {
                            // 4 - check the return of the create method
                            AProxy loadedA = response.get(0);
                            ATProxy loadedAt = loadedA.getAt();
                            AbstractVProxy loadedV = loadedA.getVs().get(0);
                            VTProxy loadedVt = loadedV.getVt();
                          }
                        });
                  }
                });
          }
        });
      }
    });

  }
}
