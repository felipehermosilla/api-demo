package py.com.api.demo.entities.naming;

import java.util.List;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitForeignKeyNameSource;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;

/**
 *
 * @author felipehermosilla
 *
 */
public class DemoImplicitNamingStrategy extends ImplicitNamingStrategyJpaCompliantImpl{

	private static final long serialVersionUID = 1L;

	@Override
	public Identifier determineForeignKeyName(ImplicitForeignKeyNameSource source) {
		return toIdentifier(
				generateForeignKeyName("fk",
						source.getTableName(),
						source.getReferencedTableName(), 
						source.getColumnNames()),
				source.getBuildingContext()
		);
	}
		
	public String generateForeignKeyName(String prefix, Identifier tableName, Identifier referencedTableName,
			List<Identifier> columnNames) {
		StringBuilder sb = new StringBuilder(prefix);
		sb.append("_").append(tableName).append("_").append(referencedTableName);
		
		for (Identifier columnName : columnNames) {
			sb.append("_").append(columnName);
		}
		return sb.toString();
	}
	
}
