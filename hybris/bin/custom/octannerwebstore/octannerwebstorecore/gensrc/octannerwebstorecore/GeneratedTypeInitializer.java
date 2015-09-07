

package octannerwebstorecore;

import java.util.*;
import java.io.Serializable;
import de.hybris.platform.util.*;
import de.hybris.platform.core.*;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.type.*;
import de.hybris.platform.persistence.type.*;
import de.hybris.platform.persistence.enumeration.*;
import de.hybris.platform.persistence.property.PersistenceManager;
import de.hybris.platform.persistence.*;

/**
 * Generated by hybris Platform.
 */
@SuppressWarnings({"cast","unused","boxing","null", "PMD"})
public class GeneratedTypeInitializer extends AbstractTypeInitializer
{
	/**
	 * Generated by hybris Platform.
	 */
	public GeneratedTypeInitializer( ManagerEJB manager, Map params )
	{
		super( manager, params );
	}


	/**
	 * Generated by hybris Platform.
	 */
	@Override
	protected void performRemoveObjects( ManagerEJB manager, Map params ) throws JaloBusinessException
	{
		// no-op by now
	}

	/**
	 * Generated by hybris Platform.
	 */
	@Override
	protected final void performCreateTypes( final ManagerEJB manager, Map params ) throws JaloBusinessException
	{
		// performCreateTypes
	
	
		createItemType(
			"HeaderNavigationComponent",
			"NavigationBarComponent",
			de.hybris.platform.acceleratorcms.jalo.components.HeaderNavigationComponent.class,
			null,
			false,
			null,
			false
		);
	
		createItemType(
			"MultipleCatalogsSyncCronJob",
			"CronJob",
			com.octanner.core.jalo.MultipleCatalogsSyncCronJob.class,
			null,
			false,
			null,
			false
		);
	
		createItemType(
			"PowertoolsSizeVariantProduct",
			"VariantProduct",
			com.octanner.core.jalo.PowertoolsSizeVariantProduct.class,
			null,
			false,
			null,
			false
		);
	
		createItemType(
			"OrganizationOrderStatistics",
			"GenericItem",
			com.octanner.core.jalo.btg.OrganizationOrderStatistics.class,
			"de.hybris.platform.persistence.octannerwebstorecore_OrganizationOrderStatistics",
			false,
			null,
			false
		);
	
		createItemType(
			"OrganizationOrdersReportingCronJob",
			"CronJob",
			com.octanner.core.jalo.btg.OrganizationOrdersReportingCronJob.class,
			null,
			false,
			null,
			false
		);
	
		createItemType(
			"BTGOrganizationTotalSpentInCurrencyLastYearOperand",
			"BTGAbstractOrderOperand",
			com.octanner.core.jalo.btg.BTGOrganizationTotalSpentInCurrencyLastYearOperand.class,
			null,
			false,
			null,
			false
		);
	
		createItemType(
			"BTGOrganizationTotalSpentInCurrencyRelativeDatesOperand",
			"BTGOrganizationTotalSpentInCurrencyLastYearOperand",
			com.octanner.core.jalo.btg.BTGOrganizationTotalSpentInCurrencyRelativeDatesOperand.class,
			null,
			false,
			null,
			false
		);
	
		createCollectionType(
			"DependentCatalogs",
			"Catalog",
			CollectionType.LIST
		);
	
	}

	/**
	 * Generated by hybris Platform.
	 */
	@Override
	protected final void performModifyTypes( final ManagerEJB manager, Map params ) throws JaloBusinessException
	{
		// performModifyTypes
	

	
	
				single_createattr_MultipleCatalogsSyncCronJob_contentCatalogs();
			
				single_createattr_MultipleCatalogsSyncCronJob_productCatalog();
			
				single_createattr_PowertoolsSizeVariantProduct_size();
			
				single_createattr_OrganizationOrderStatistics_unit();
			
				single_createattr_OrganizationOrderStatistics_currency();
			
				single_createattr_OrganizationOrderStatistics_orderTotal();
			
				single_createattr_OrganizationOrderStatistics_date();
			
				single_createattr_OrganizationOrderStatistics_category();
			
				single_createattr_OrganizationOrderStatistics_catalog();
			
				single_createattr_BTGOrganizationTotalSpentInCurrencyLastYearOperand_currency();
			
				single_createattr_BTGOrganizationTotalSpentInCurrencyLastYearOperand_productCatalogId();
			
				single_createattr_BTGOrganizationTotalSpentInCurrencyLastYearOperand_categoryCode();
			
				single_createattr_BTGOrganizationTotalSpentInCurrencyRelativeDatesOperand_value();
			
				single_createattr_BTGOrganizationTotalSpentInCurrencyRelativeDatesOperand_unit();
			

	}

	
	public void single_createattr_MultipleCatalogsSyncCronJob_contentCatalogs() throws JaloBusinessException
	{
		
						Map sqlColumnDefinitions = null;
					
				createPropertyAttribute(
					"MultipleCatalogsSyncCronJob", 
					"contentCatalogs",  
					null,
					"DependentCatalogs",
					de.hybris.platform.jalo.type.AttributeDescriptor.READ_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.WRITE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.INITIAL_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.REMOVE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.SEARCH_FLAG,
					null,
					sqlColumnDefinitions
				);
			
	}
	
	public void single_createattr_MultipleCatalogsSyncCronJob_productCatalog() throws JaloBusinessException
	{
		
						Map sqlColumnDefinitions = null;
					
				createPropertyAttribute(
					"MultipleCatalogsSyncCronJob", 
					"productCatalog",  
					null,
					"Catalog",
					de.hybris.platform.jalo.type.AttributeDescriptor.READ_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.WRITE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.INITIAL_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.REMOVE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.SEARCH_FLAG,
					null,
					sqlColumnDefinitions
				);
			
	}
	
	public void single_createattr_PowertoolsSizeVariantProduct_size() throws JaloBusinessException
	{
		
						Map sqlColumnDefinitions = null;
					
				createPropertyAttribute(
					"PowertoolsSizeVariantProduct", 
					"size",  
					null,
					"localized:java.lang.String",
					de.hybris.platform.jalo.type.AttributeDescriptor.READ_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.WRITE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.OPTIONAL_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.REMOVE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.SEARCH_FLAG,
					"VariantAttributeDescriptor",
					sqlColumnDefinitions
				);
			
	}
	
	public void single_createattr_OrganizationOrderStatistics_unit() throws JaloBusinessException
	{
		
						Map sqlColumnDefinitions = null;
					
				createPropertyAttribute(
					"OrganizationOrderStatistics", 
					"unit",  
					null,
					"B2BUnit",
					de.hybris.platform.jalo.type.AttributeDescriptor.READ_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.WRITE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.OPTIONAL_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.REMOVE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.SEARCH_FLAG,
					null,
					sqlColumnDefinitions
				);
			
	}
	
	public void single_createattr_OrganizationOrderStatistics_currency() throws JaloBusinessException
	{
		
						Map sqlColumnDefinitions = null;
					
				createPropertyAttribute(
					"OrganizationOrderStatistics", 
					"currency",  
					null,
					"Currency",
					de.hybris.platform.jalo.type.AttributeDescriptor.READ_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.WRITE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.OPTIONAL_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.REMOVE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.SEARCH_FLAG,
					null,
					sqlColumnDefinitions
				);
			
	}
	
	public void single_createattr_OrganizationOrderStatistics_orderTotal() throws JaloBusinessException
	{
		
						Map sqlColumnDefinitions = null;
					
				createPropertyAttribute(
					"OrganizationOrderStatistics", 
					"orderTotal",  
					null,
					"java.lang.Double",
					de.hybris.platform.jalo.type.AttributeDescriptor.READ_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.WRITE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.OPTIONAL_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.REMOVE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.SEARCH_FLAG,
					null,
					sqlColumnDefinitions
				);
			
	}
	
	public void single_createattr_OrganizationOrderStatistics_date() throws JaloBusinessException
	{
		
						Map sqlColumnDefinitions = null;
					
				createPropertyAttribute(
					"OrganizationOrderStatistics", 
					"date",  
					null,
					"java.util.Date",
					de.hybris.platform.jalo.type.AttributeDescriptor.READ_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.WRITE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.OPTIONAL_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.REMOVE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.SEARCH_FLAG,
					null,
					sqlColumnDefinitions
				);
			
	}
	
	public void single_createattr_OrganizationOrderStatistics_category() throws JaloBusinessException
	{
		
						Map sqlColumnDefinitions = null;
					
				createPropertyAttribute(
					"OrganizationOrderStatistics", 
					"category",  
					null,
					"java.lang.String",
					de.hybris.platform.jalo.type.AttributeDescriptor.READ_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.WRITE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.OPTIONAL_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.REMOVE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.SEARCH_FLAG,
					null,
					sqlColumnDefinitions
				);
			
	}
	
	public void single_createattr_OrganizationOrderStatistics_catalog() throws JaloBusinessException
	{
		
						Map sqlColumnDefinitions = null;
					
				createPropertyAttribute(
					"OrganizationOrderStatistics", 
					"catalog",  
					null,
					"java.lang.String",
					de.hybris.platform.jalo.type.AttributeDescriptor.READ_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.WRITE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.OPTIONAL_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.REMOVE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.SEARCH_FLAG,
					null,
					sqlColumnDefinitions
				);
			
	}
	
	public void single_createattr_BTGOrganizationTotalSpentInCurrencyLastYearOperand_currency() throws JaloBusinessException
	{
		
						Map sqlColumnDefinitions = null;
					
				createPropertyAttribute(
					"BTGOrganizationTotalSpentInCurrencyLastYearOperand", 
					"currency",  
					null,
					"Currency",
					de.hybris.platform.jalo.type.AttributeDescriptor.READ_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.WRITE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.OPTIONAL_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.REMOVE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.SEARCH_FLAG,
					null,
					sqlColumnDefinitions
				);
			
	}
	
	public void single_createattr_BTGOrganizationTotalSpentInCurrencyLastYearOperand_productCatalogId() throws JaloBusinessException
	{
		
						Map sqlColumnDefinitions = null;
					
				createPropertyAttribute(
					"BTGOrganizationTotalSpentInCurrencyLastYearOperand", 
					"productCatalogId",  
					null,
					"java.lang.String",
					de.hybris.platform.jalo.type.AttributeDescriptor.READ_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.WRITE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.OPTIONAL_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.REMOVE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.SEARCH_FLAG,
					null,
					sqlColumnDefinitions
				);
			
	}
	
	public void single_createattr_BTGOrganizationTotalSpentInCurrencyLastYearOperand_categoryCode() throws JaloBusinessException
	{
		
						Map sqlColumnDefinitions = null;
					
				createPropertyAttribute(
					"BTGOrganizationTotalSpentInCurrencyLastYearOperand", 
					"categoryCode",  
					null,
					"java.lang.String",
					de.hybris.platform.jalo.type.AttributeDescriptor.READ_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.WRITE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.OPTIONAL_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.REMOVE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.SEARCH_FLAG,
					null,
					sqlColumnDefinitions
				);
			
	}
	
	public void single_createattr_BTGOrganizationTotalSpentInCurrencyRelativeDatesOperand_value() throws JaloBusinessException
	{
		
						Map sqlColumnDefinitions = null;
					
				createPropertyAttribute(
					"BTGOrganizationTotalSpentInCurrencyRelativeDatesOperand", 
					"value",  
					null,
					"java.lang.Integer",
					de.hybris.platform.jalo.type.AttributeDescriptor.READ_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.WRITE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.OPTIONAL_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.REMOVE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.SEARCH_FLAG,
					null,
					sqlColumnDefinitions
				);
			
	}
	
	public void single_createattr_BTGOrganizationTotalSpentInCurrencyRelativeDatesOperand_unit() throws JaloBusinessException
	{
		
						Map sqlColumnDefinitions = null;
					
				createPropertyAttribute(
					"BTGOrganizationTotalSpentInCurrencyRelativeDatesOperand", 
					"unit",  
					null,
					"IntervalResolution",
					de.hybris.platform.jalo.type.AttributeDescriptor.READ_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.WRITE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.OPTIONAL_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.REMOVE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.SEARCH_FLAG,
					null,
					sqlColumnDefinitions
				);
			
	}
	


	/**
	 * Generated by hybris Platform.
	 */
	@Override
	protected final void performCreateObjects( final ManagerEJB manager, Map params ) throws JaloBusinessException
	{
		// performCreateObjects
	
	
				{
				Map customPropsMap = new HashMap();
				
				setItemTypeProperties(
					"HeaderNavigationComponent",
					false,
					true,
					true,
					null,
					customPropsMap
				);
				}
			
				{
				Map customPropsMap = new HashMap();
				
				setItemTypeProperties(
					"MultipleCatalogsSyncCronJob",
					false,
					true,
					true,
					null,
					customPropsMap
				);
				}
			
			single_setAttributeProperties_MultipleCatalogsSyncCronJob_contentCatalogs();
		
			single_setAttributeProperties_MultipleCatalogsSyncCronJob_productCatalog();
		
				{
				Map customPropsMap = new HashMap();
				
				setItemTypeProperties(
					"PowertoolsSizeVariantProduct",
					false,
					true,
					true,
					null,
					customPropsMap
				);
				}
			
			single_setAttributeProperties_PowertoolsSizeVariantProduct_size();
		
				{
				Map customPropsMap = new HashMap();
				
				setItemTypeProperties(
					"OrganizationOrderStatistics",
					false,
					true,
					true,
					null,
					customPropsMap
				);
				}
			
			single_setAttributeProperties_OrganizationOrderStatistics_unit();
		
			single_setAttributeProperties_OrganizationOrderStatistics_currency();
		
			single_setAttributeProperties_OrganizationOrderStatistics_orderTotal();
		
			single_setAttributeProperties_OrganizationOrderStatistics_date();
		
			single_setAttributeProperties_OrganizationOrderStatistics_category();
		
			single_setAttributeProperties_OrganizationOrderStatistics_catalog();
		
				{
				Map customPropsMap = new HashMap();
				
				setItemTypeProperties(
					"OrganizationOrdersReportingCronJob",
					false,
					true,
					true,
					null,
					customPropsMap
				);
				}
			
				{
				Map customPropsMap = new HashMap();
				
				setItemTypeProperties(
					"BTGOrganizationTotalSpentInCurrencyLastYearOperand",
					false,
					true,
					true,
					null,
					customPropsMap
				);
				}
			
			single_setAttributeProperties_BTGOrganizationTotalSpentInCurrencyLastYearOperand_currency();
		
			single_setAttributeProperties_BTGOrganizationTotalSpentInCurrencyLastYearOperand_productCatalogId();
		
			single_setAttributeProperties_BTGOrganizationTotalSpentInCurrencyLastYearOperand_categoryCode();
		
				{
				Map customPropsMap = new HashMap();
				
				setItemTypeProperties(
					"BTGOrganizationTotalSpentInCurrencyRelativeDatesOperand",
					false,
					true,
					true,
					null,
					customPropsMap
				);
				}
			
			single_setAttributeProperties_BTGOrganizationTotalSpentInCurrencyRelativeDatesOperand_value();
		
			single_setAttributeProperties_BTGOrganizationTotalSpentInCurrencyRelativeDatesOperand_unit();
		
				setDefaultProperties(
					"DependentCatalogs",
					true,
					true,
					null
				);
			
	}


		
						public void single_setAttributeProperties_MultipleCatalogsSyncCronJob_contentCatalogs() throws JaloBusinessException
						{
							
							
							
							Map customPropsMap = new HashMap();
							
							setAttributeProperties(
								"MultipleCatalogsSyncCronJob", 
								"contentCatalogs",
								false, 
								null,
								null,
								null,
								true,
								true,
								null,
								customPropsMap,
								null
							);
						}
					
						public void single_setAttributeProperties_MultipleCatalogsSyncCronJob_productCatalog() throws JaloBusinessException
						{
							
							
							
							Map customPropsMap = new HashMap();
							
							setAttributeProperties(
								"MultipleCatalogsSyncCronJob", 
								"productCatalog",
								false, 
								null,
								null,
								null,
								true,
								true,
								null,
								customPropsMap,
								null
							);
						}
					
						public void single_setAttributeProperties_PowertoolsSizeVariantProduct_size() throws JaloBusinessException
						{
							
							
							
							Map customPropsMap = new HashMap();
							
							setAttributeProperties(
								"PowertoolsSizeVariantProduct", 
								"size",
								false, 
								null,
								null,
								null,
								true,
								true,
								"VariantAttributeDescriptor",
								customPropsMap,
								null
							);
						}
					
						public void single_setAttributeProperties_OrganizationOrderStatistics_unit() throws JaloBusinessException
						{
							
							
							
							Map customPropsMap = new HashMap();
							
							setAttributeProperties(
								"OrganizationOrderStatistics", 
								"unit",
								false, 
								null,
								null,
								null,
								true,
								true,
								null,
								customPropsMap,
								null
							);
						}
					
						public void single_setAttributeProperties_OrganizationOrderStatistics_currency() throws JaloBusinessException
						{
							
							
							
							Map customPropsMap = new HashMap();
							
							setAttributeProperties(
								"OrganizationOrderStatistics", 
								"currency",
								false, 
								null,
								null,
								null,
								true,
								true,
								null,
								customPropsMap,
								null
							);
						}
					
						public void single_setAttributeProperties_OrganizationOrderStatistics_orderTotal() throws JaloBusinessException
						{
							
							
							
							Map customPropsMap = new HashMap();
							
							setAttributeProperties(
								"OrganizationOrderStatistics", 
								"orderTotal",
								false, 
								null,
								null,
								null,
								true,
								true,
								null,
								customPropsMap,
								null
							);
						}
					
						public void single_setAttributeProperties_OrganizationOrderStatistics_date() throws JaloBusinessException
						{
							
							
							
							Map customPropsMap = new HashMap();
							
							setAttributeProperties(
								"OrganizationOrderStatistics", 
								"date",
								false, 
								null,
								null,
								null,
								true,
								true,
								null,
								customPropsMap,
								null
							);
						}
					
						public void single_setAttributeProperties_OrganizationOrderStatistics_category() throws JaloBusinessException
						{
							
							
							
							Map customPropsMap = new HashMap();
							
							setAttributeProperties(
								"OrganizationOrderStatistics", 
								"category",
								false, 
								null,
								null,
								null,
								true,
								true,
								null,
								customPropsMap,
								null
							);
						}
					
						public void single_setAttributeProperties_OrganizationOrderStatistics_catalog() throws JaloBusinessException
						{
							
							
							
							Map customPropsMap = new HashMap();
							
							setAttributeProperties(
								"OrganizationOrderStatistics", 
								"catalog",
								false, 
								null,
								null,
								null,
								true,
								true,
								null,
								customPropsMap,
								null
							);
						}
					
						public void single_setAttributeProperties_BTGOrganizationTotalSpentInCurrencyLastYearOperand_currency() throws JaloBusinessException
						{
							
							
							
							Map customPropsMap = new HashMap();
							
							setAttributeProperties(
								"BTGOrganizationTotalSpentInCurrencyLastYearOperand", 
								"currency",
								false, 
								null,
								null,
								null,
								true,
								true,
								null,
								customPropsMap,
								null
							);
						}
					
						public void single_setAttributeProperties_BTGOrganizationTotalSpentInCurrencyLastYearOperand_productCatalogId() throws JaloBusinessException
						{
							
							
							
							Map customPropsMap = new HashMap();
							
							setAttributeProperties(
								"BTGOrganizationTotalSpentInCurrencyLastYearOperand", 
								"productCatalogId",
								false, 
								null,
								null,
								null,
								true,
								true,
								null,
								customPropsMap,
								null
							);
						}
					
						public void single_setAttributeProperties_BTGOrganizationTotalSpentInCurrencyLastYearOperand_categoryCode() throws JaloBusinessException
						{
							
							
							
							Map customPropsMap = new HashMap();
							
							setAttributeProperties(
								"BTGOrganizationTotalSpentInCurrencyLastYearOperand", 
								"categoryCode",
								false, 
								null,
								null,
								null,
								true,
								true,
								null,
								customPropsMap,
								null
							);
						}
					
						public void single_setAttributeProperties_BTGOrganizationTotalSpentInCurrencyRelativeDatesOperand_value() throws JaloBusinessException
						{
							
							
							
							Map customPropsMap = new HashMap();
							
							setAttributeProperties(
								"BTGOrganizationTotalSpentInCurrencyRelativeDatesOperand", 
								"value",
								false, 
								null,
								null,
								null,
								true,
								true,
								null,
								customPropsMap,
								null
							);
						}
					
						public void single_setAttributeProperties_BTGOrganizationTotalSpentInCurrencyRelativeDatesOperand_unit() throws JaloBusinessException
						{
							
							
							
							Map customPropsMap = new HashMap();
							
							setAttributeProperties(
								"BTGOrganizationTotalSpentInCurrencyRelativeDatesOperand", 
								"unit",
								false, 
								null,
								null,
								null,
								true,
								true,
								null,
								customPropsMap,
								null
							);
						}
					
}

	