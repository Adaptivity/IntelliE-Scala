package de.thatsich.intellie.common.util.logging;

/**
 @author thatsIch
 @since 05.03.14. */
public interface ILog
{
	void info( String format, Object... data );

	void warn( String format, Object... data );

	void debug( String format, Object... data );

	void trace( Throwable exception );

	void severe( String format, Object... data );
}