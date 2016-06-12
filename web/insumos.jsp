<%--
  Created by IntelliJ IDEA.
  User: Livia
  Date: 12/06/2016
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
  </body>
  <!DOCTYPE html>
  <ui:composition xmlns="http://www.w3.org/1999/xhtml"
                  xmlns:h="http://java.sun.com/jsf/html"
                  xmlns:f="http://java.sun.com/jsf/core"
                  xmlns:ui="http://java.sun.com/jsf/facelets"
                  xmlns:a4j="http://richfaces.org/a4j"
                  xmlns:rich="http://richfaces.org/rich">
    <h:form>
      <fieldset>
        <legend><b>Ajax loading</b></legend>
        <h:outputText value="Turn ajax loading on/off:"/>
        <h:selectBooleanCheckbox valueChangeListener="#{carsBean.switchAjaxLoading}">
          <a4j:ajax event="click" render="table @this"/>
        </h:selectBooleanCheckbox>
      </fieldset>
      <br/>
      <rich:extendedDataTable value="#{carsBean.allInventoryItems}"
                              var="car" id="table" frozenColumns="2"
                              style="height:300px; width:500px;" selectionMode="none"
                              clientRows="#{carsBean.clientRows}"
                              showColumnControl="true">
        <f:facet name="header">
          <h:outputText value="Cars marketplace"/>
        </f:facet>
        <rich:column>
          <f:facet name="header">
            <h:outputText value="Vendor"/>
          </f:facet>
          <h:outputText value="#{car.vendor}"/>
        </rich:column>
        <rich:column>
          <f:facet name="header">
            <h:outputText value="Model"/>
          </f:facet>
          <h:outputText value="#{car.model}"/>
        </rich:column>
        <rich:column>
          <f:facet name="header">
            <h:outputText value="Price"/>
          </f:facet>
          <h:outputText value="#{car.price}"/>
        </rich:column>
        <rich:column>
          <f:facet name="header">
            <h:outputText value="Mileage"/>
          </f:facet>
          <h:outputText value="#{car.mileage}"/>
        </rich:column>
        <rich:column>
          <f:facet name="header">
            <h:outputText value="VIN Code"/>
          </f:facet>
          <h:outputText value="#{car.vin}"/>
        </rich:column>
        <rich:column>
          <f:facet name="header">
            <h:outputText value="Items stock"/>
          </f:facet>
          <h:outputText value="#{car.stock}"/>
        </rich:column>
        <rich:column>
          <f:facet name="header">
            <h:outputText value="Days Live"/>
          </f:facet>
          <h:outputText value="#{car.daysLive}"/>
        </rich:column>
      </rich:extendedDataTable>
    </h:form>
  </ui:composition>
</html>