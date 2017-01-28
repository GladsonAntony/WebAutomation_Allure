package utils;

import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import org.monte.media.Format;
import org.monte.media.Registry;
import org.monte.screenrecorder.ScreenRecorder;

/**
 * @Author Gladson Antony
 * @Date 25-Dec-2016
 */

public class SpecializedScreenRecorder extends ScreenRecorder 
{

	private String name;
	public ScreenRecorder screenRecorder;

	public SpecializedScreenRecorder(GraphicsConfiguration cfg,
			Rectangle captureArea, Format fileFormat, Format screenFormat,
			Format mouseFormat, Format audioFormat, File movieFolder,
			String name) throws Exception 
	{
		super(cfg, captureArea, fileFormat, screenFormat, mouseFormat,
				audioFormat, movieFolder);
		this.name = name;

	}

	@Override
	protected File createMovieFile(Format fileFormat) throws IOException 
	{
		if (!movieFolder.exists()) 
		{
			movieFolder.mkdirs();
		} 
		else if (!movieFolder.isDirectory()) 
		{
			throw new IOException("\"" + movieFolder + "\" is not a directory.");
		}

		return new File(movieFolder, name + "." + Registry.getInstance().getExtension(fileFormat));
	}

}