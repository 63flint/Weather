package com.flint.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flint.weather.dto.ForecastResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class WeatherApiTest {

	@Test
	void contextLoads() throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		//Path path = Path.of("/resources/weather.json");
		String str = "{\n" +
				"  \"cod\": \"200\",\n" +
				"  \"message\": 0,\n" +
				"  \"cnt\": 40,\n" +
				"  \"list\": [\n" +
				"    {\n" +
				"      \"dt\": 1671040800,\n" +
				"      \"main\": {\n" +
				"        \"temp\": -5.94,\n" +
				"        \"feels_like\": -12.3,\n" +
				"        \"temp_min\": -5.94,\n" +
				"        \"temp_max\": -5.94,\n" +
				"        \"pressure\": 1026,\n" +
				"        \"sea_level\": 1026,\n" +
				"        \"grnd_level\": 1012,\n" +
				"        \"humidity\": 75,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 803,\n" +
				"          \"main\": \"Clouds\",\n" +
				"          \"description\": \"broken clouds\",\n" +
				"          \"icon\": \"04n\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 78\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 4.94,\n" +
				"        \"deg\": 161,\n" +
				"        \"gust\": 13.01\n" +
				"      },\n" +
				"      \"visibility\": 10000,\n" +
				"      \"pop\": 0,\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"n\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-14 18:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671051600,\n" +
				"      \"main\": {\n" +
				"        \"temp\": -5.87,\n" +
				"        \"feels_like\": -11.85,\n" +
				"        \"temp_min\": -5.87,\n" +
				"        \"temp_max\": -5.73,\n" +
				"        \"pressure\": 1026,\n" +
				"        \"sea_level\": 1026,\n" +
				"        \"grnd_level\": 1012,\n" +
				"        \"humidity\": 76,\n" +
				"        \"temp_kf\": -0.14\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 804,\n" +
				"          \"main\": \"Clouds\",\n" +
				"          \"description\": \"overcast clouds\",\n" +
				"          \"icon\": \"04n\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 85\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 4.44,\n" +
				"        \"deg\": 163,\n" +
				"        \"gust\": 10.7\n" +
				"      },\n" +
				"      \"visibility\": 10000,\n" +
				"      \"pop\": 0.12,\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"n\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-14 21:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671062400,\n" +
				"      \"main\": {\n" +
				"        \"temp\": -5.99,\n" +
				"        \"feels_like\": -11.19,\n" +
				"        \"temp_min\": -6.02,\n" +
				"        \"temp_max\": -5.99,\n" +
				"        \"pressure\": 1027,\n" +
				"        \"sea_level\": 1027,\n" +
				"        \"grnd_level\": 1012,\n" +
				"        \"humidity\": 89,\n" +
				"        \"temp_kf\": 0.03\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 600,\n" +
				"          \"main\": \"Snow\",\n" +
				"          \"description\": \"light snow\",\n" +
				"          \"icon\": \"13n\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 93\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 3.49,\n" +
				"        \"deg\": 167,\n" +
				"        \"gust\": 8\n" +
				"      },\n" +
				"      \"visibility\": 130,\n" +
				"      \"pop\": 0.8,\n" +
				"      \"snow\": {\n" +
				"        \"3h\": 1.38\n" +
				"      },\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"n\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-15 00:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671073200,\n" +
				"      \"main\": {\n" +
				"        \"temp\": -7.05,\n" +
				"        \"feels_like\": -10.61,\n" +
				"        \"temp_min\": -7.05,\n" +
				"        \"temp_max\": -7.05,\n" +
				"        \"pressure\": 1027,\n" +
				"        \"sea_level\": 1027,\n" +
				"        \"grnd_level\": 1012,\n" +
				"        \"humidity\": 97,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 600,\n" +
				"          \"main\": \"Snow\",\n" +
				"          \"description\": \"light snow\",\n" +
				"          \"icon\": \"13n\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 99\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 1.96,\n" +
				"        \"deg\": 167,\n" +
				"        \"gust\": 3.12\n" +
				"      },\n" +
				"      \"visibility\": 1090,\n" +
				"      \"pop\": 0.56,\n" +
				"      \"snow\": {\n" +
				"        \"3h\": 0.38\n" +
				"      },\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"n\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-15 03:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671084000,\n" +
				"      \"main\": {\n" +
				"        \"temp\": -8.35,\n" +
				"        \"feels_like\": -10.93,\n" +
				"        \"temp_min\": -8.35,\n" +
				"        \"temp_max\": -8.35,\n" +
				"        \"pressure\": 1029,\n" +
				"        \"sea_level\": 1029,\n" +
				"        \"grnd_level\": 1014,\n" +
				"        \"humidity\": 99,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 804,\n" +
				"          \"main\": \"Clouds\",\n" +
				"          \"description\": \"overcast clouds\",\n" +
				"          \"icon\": \"04d\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 93\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 1.34,\n" +
				"        \"deg\": 194,\n" +
				"        \"gust\": 1.31\n" +
				"      },\n" +
				"      \"visibility\": 4251,\n" +
				"      \"pop\": 0.36,\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"d\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-15 06:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671094800,\n" +
				"      \"main\": {\n" +
				"        \"temp\": -5.58,\n" +
				"        \"feels_like\": -7.86,\n" +
				"        \"temp_min\": -5.58,\n" +
				"        \"temp_max\": -5.58,\n" +
				"        \"pressure\": 1030,\n" +
				"        \"sea_level\": 1030,\n" +
				"        \"grnd_level\": 1015,\n" +
				"        \"humidity\": 94,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 804,\n" +
				"          \"main\": \"Clouds\",\n" +
				"          \"description\": \"overcast clouds\",\n" +
				"          \"icon\": \"04d\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 95\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 1.37,\n" +
				"        \"deg\": 250,\n" +
				"        \"gust\": 2.2\n" +
				"      },\n" +
				"      \"visibility\": 7968,\n" +
				"      \"pop\": 0,\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"d\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-15 09:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671105600,\n" +
				"      \"main\": {\n" +
				"        \"temp\": -7.75,\n" +
				"        \"feels_like\": -7.75,\n" +
				"        \"temp_min\": -7.75,\n" +
				"        \"temp_max\": -7.75,\n" +
				"        \"pressure\": 1031,\n" +
				"        \"sea_level\": 1031,\n" +
				"        \"grnd_level\": 1016,\n" +
				"        \"humidity\": 98,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 804,\n" +
				"          \"main\": \"Clouds\",\n" +
				"          \"description\": \"overcast clouds\",\n" +
				"          \"icon\": \"04d\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 91\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 0.91,\n" +
				"        \"deg\": 245,\n" +
				"        \"gust\": 0.91\n" +
				"      },\n" +
				"      \"visibility\": 7689,\n" +
				"      \"pop\": 0,\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"d\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-15 12:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671116400,\n" +
				"      \"main\": {\n" +
				"        \"temp\": -9.26,\n" +
				"        \"feels_like\": -9.26,\n" +
				"        \"temp_min\": -9.26,\n" +
				"        \"temp_max\": -9.26,\n" +
				"        \"pressure\": 1032,\n" +
				"        \"sea_level\": 1032,\n" +
				"        \"grnd_level\": 1017,\n" +
				"        \"humidity\": 99,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 804,\n" +
				"          \"main\": \"Clouds\",\n" +
				"          \"description\": \"overcast clouds\",\n" +
				"          \"icon\": \"04n\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 92\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 0.51,\n" +
				"        \"deg\": 172,\n" +
				"        \"gust\": 0.5\n" +
				"      },\n" +
				"      \"visibility\": 4799,\n" +
				"      \"pop\": 0,\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"n\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-15 15:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671127200,\n" +
				"      \"main\": {\n" +
				"        \"temp\": -10.22,\n" +
				"        \"feels_like\": -10.22,\n" +
				"        \"temp_min\": -10.22,\n" +
				"        \"temp_max\": -10.22,\n" +
				"        \"pressure\": 1032,\n" +
				"        \"sea_level\": 1032,\n" +
				"        \"grnd_level\": 1018,\n" +
				"        \"humidity\": 99,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 804,\n" +
				"          \"main\": \"Clouds\",\n" +
				"          \"description\": \"overcast clouds\",\n" +
				"          \"icon\": \"04n\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 94\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 0.95,\n" +
				"        \"deg\": 143,\n" +
				"        \"gust\": 0.9\n" +
				"      },\n" +
				"      \"visibility\": 2966,\n" +
				"      \"pop\": 0,\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"n\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-15 18:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671138000,\n" +
				"      \"main\": {\n" +
				"        \"temp\": -10.65,\n" +
				"        \"feels_like\": -13.83,\n" +
				"        \"temp_min\": -10.65,\n" +
				"        \"temp_max\": -10.65,\n" +
				"        \"pressure\": 1033,\n" +
				"        \"sea_level\": 1033,\n" +
				"        \"grnd_level\": 1018,\n" +
				"        \"humidity\": 99,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 804,\n" +
				"          \"main\": \"Clouds\",\n" +
				"          \"description\": \"overcast clouds\",\n" +
				"          \"icon\": \"04n\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 100\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 1.47,\n" +
				"        \"deg\": 119,\n" +
				"        \"gust\": 1.41\n" +
				"      },\n" +
				"      \"visibility\": 2158,\n" +
				"      \"pop\": 0,\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"n\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-15 21:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671148800,\n" +
				"      \"main\": {\n" +
				"        \"temp\": -10.75,\n" +
				"        \"feels_like\": -15.05,\n" +
				"        \"temp_min\": -10.75,\n" +
				"        \"temp_max\": -10.75,\n" +
				"        \"pressure\": 1033,\n" +
				"        \"sea_level\": 1033,\n" +
				"        \"grnd_level\": 1018,\n" +
				"        \"humidity\": 99,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 804,\n" +
				"          \"main\": \"Clouds\",\n" +
				"          \"description\": \"overcast clouds\",\n" +
				"          \"icon\": \"04n\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 100\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 2.04,\n" +
				"        \"deg\": 114,\n" +
				"        \"gust\": 2.71\n" +
				"      },\n" +
				"      \"visibility\": 3711,\n" +
				"      \"pop\": 0,\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"n\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-16 00:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671159600,\n" +
				"      \"main\": {\n" +
				"        \"temp\": -10.72,\n" +
				"        \"feels_like\": -15.13,\n" +
				"        \"temp_min\": -10.72,\n" +
				"        \"temp_max\": -10.72,\n" +
				"        \"pressure\": 1032,\n" +
				"        \"sea_level\": 1032,\n" +
				"        \"grnd_level\": 1017,\n" +
				"        \"humidity\": 98,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 804,\n" +
				"          \"main\": \"Clouds\",\n" +
				"          \"description\": \"overcast clouds\",\n" +
				"          \"icon\": \"04n\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 99\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 2.11,\n" +
				"        \"deg\": 109,\n" +
				"        \"gust\": 3.81\n" +
				"      },\n" +
				"      \"visibility\": 5858,\n" +
				"      \"pop\": 0,\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"n\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-16 03:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671170400,\n" +
				"      \"main\": {\n" +
				"        \"temp\": -9.03,\n" +
				"        \"feels_like\": -13.58,\n" +
				"        \"temp_min\": -9.03,\n" +
				"        \"temp_max\": -9.03,\n" +
				"        \"pressure\": 1032,\n" +
				"        \"sea_level\": 1032,\n" +
				"        \"grnd_level\": 1018,\n" +
				"        \"humidity\": 92,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 804,\n" +
				"          \"main\": \"Clouds\",\n" +
				"          \"description\": \"overcast clouds\",\n" +
				"          \"icon\": \"04d\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 99\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 2.4,\n" +
				"        \"deg\": 130,\n" +
				"        \"gust\": 7.5\n" +
				"      },\n" +
				"      \"visibility\": 10000,\n" +
				"      \"pop\": 0,\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"d\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-16 06:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671181200,\n" +
				"      \"main\": {\n" +
				"        \"temp\": -5.81,\n" +
				"        \"feels_like\": -11,\n" +
				"        \"temp_min\": -5.81,\n" +
				"        \"temp_max\": -5.81,\n" +
				"        \"pressure\": 1031,\n" +
				"        \"sea_level\": 1031,\n" +
				"        \"grnd_level\": 1017,\n" +
				"        \"humidity\": 85,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 804,\n" +
				"          \"main\": \"Clouds\",\n" +
				"          \"description\": \"overcast clouds\",\n" +
				"          \"icon\": \"04d\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 100\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 3.52,\n" +
				"        \"deg\": 154,\n" +
				"        \"gust\": 9.4\n" +
				"      },\n" +
				"      \"visibility\": 10000,\n" +
				"      \"pop\": 0,\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"d\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-16 09:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671192000,\n" +
				"      \"main\": {\n" +
				"        \"temp\": -4.95,\n" +
				"        \"feels_like\": -9.21,\n" +
				"        \"temp_min\": -4.95,\n" +
				"        \"temp_max\": -4.95,\n" +
				"        \"pressure\": 1030,\n" +
				"        \"sea_level\": 1030,\n" +
				"        \"grnd_level\": 1016,\n" +
				"        \"humidity\": 84,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 804,\n" +
				"          \"main\": \"Clouds\",\n" +
				"          \"description\": \"overcast clouds\",\n" +
				"          \"icon\": \"04d\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 100\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 2.78,\n" +
				"        \"deg\": 174,\n" +
				"        \"gust\": 8.45\n" +
				"      },\n" +
				"      \"visibility\": 10000,\n" +
				"      \"pop\": 0,\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"d\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-16 12:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671202800,\n" +
				"      \"main\": {\n" +
				"        \"temp\": -7.28,\n" +
				"        \"feels_like\": -11.15,\n" +
				"        \"temp_min\": -7.28,\n" +
				"        \"temp_max\": -7.28,\n" +
				"        \"pressure\": 1032,\n" +
				"        \"sea_level\": 1032,\n" +
				"        \"grnd_level\": 1017,\n" +
				"        \"humidity\": 90,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 804,\n" +
				"          \"main\": \"Clouds\",\n" +
				"          \"description\": \"overcast clouds\",\n" +
				"          \"icon\": \"04n\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 100\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 2.14,\n" +
				"        \"deg\": 162,\n" +
				"        \"gust\": 5.01\n" +
				"      },\n" +
				"      \"visibility\": 10000,\n" +
				"      \"pop\": 0,\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"n\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-16 15:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671213600,\n" +
				"      \"main\": {\n" +
				"        \"temp\": -7.22,\n" +
				"        \"feels_like\": -11.81,\n" +
				"        \"temp_min\": -7.22,\n" +
				"        \"temp_max\": -7.22,\n" +
				"        \"pressure\": 1031,\n" +
				"        \"sea_level\": 1031,\n" +
				"        \"grnd_level\": 1017,\n" +
				"        \"humidity\": 89,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 804,\n" +
				"          \"main\": \"Clouds\",\n" +
				"          \"description\": \"overcast clouds\",\n" +
				"          \"icon\": \"04n\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 99\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 2.69,\n" +
				"        \"deg\": 165,\n" +
				"        \"gust\": 6.33\n" +
				"      },\n" +
				"      \"visibility\": 10000,\n" +
				"      \"pop\": 0,\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"n\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-16 18:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671224400,\n" +
				"      \"main\": {\n" +
				"        \"temp\": -8.5,\n" +
				"        \"feels_like\": -12.21,\n" +
				"        \"temp_min\": -8.5,\n" +
				"        \"temp_max\": -8.5,\n" +
				"        \"pressure\": 1032,\n" +
				"        \"sea_level\": 1032,\n" +
				"        \"grnd_level\": 1017,\n" +
				"        \"humidity\": 92,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 804,\n" +
				"          \"main\": \"Clouds\",\n" +
				"          \"description\": \"overcast clouds\",\n" +
				"          \"icon\": \"04n\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 100\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 1.91,\n" +
				"        \"deg\": 161,\n" +
				"        \"gust\": 1.82\n" +
				"      },\n" +
				"      \"visibility\": 10000,\n" +
				"      \"pop\": 0,\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"n\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-16 21:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671235200,\n" +
				"      \"main\": {\n" +
				"        \"temp\": -8.36,\n" +
				"        \"feels_like\": -11.73,\n" +
				"        \"temp_min\": -8.36,\n" +
				"        \"temp_max\": -8.36,\n" +
				"        \"pressure\": 1032,\n" +
				"        \"sea_level\": 1032,\n" +
				"        \"grnd_level\": 1017,\n" +
				"        \"humidity\": 92,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 804,\n" +
				"          \"main\": \"Clouds\",\n" +
				"          \"description\": \"overcast clouds\",\n" +
				"          \"icon\": \"04n\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 100\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 1.73,\n" +
				"        \"deg\": 112,\n" +
				"        \"gust\": 1.63\n" +
				"      },\n" +
				"      \"visibility\": 10000,\n" +
				"      \"pop\": 0,\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"n\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-17 00:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671246000,\n" +
				"      \"main\": {\n" +
				"        \"temp\": -5.19,\n" +
				"        \"feels_like\": -8.44,\n" +
				"        \"temp_min\": -5.19,\n" +
				"        \"temp_max\": -5.19,\n" +
				"        \"pressure\": 1031,\n" +
				"        \"sea_level\": 1031,\n" +
				"        \"grnd_level\": 1017,\n" +
				"        \"humidity\": 86,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 804,\n" +
				"          \"main\": \"Clouds\",\n" +
				"          \"description\": \"overcast clouds\",\n" +
				"          \"icon\": \"04n\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 100\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 1.96,\n" +
				"        \"deg\": 103,\n" +
				"        \"gust\": 2.72\n" +
				"      },\n" +
				"      \"visibility\": 10000,\n" +
				"      \"pop\": 0,\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"n\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-17 03:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671256800,\n" +
				"      \"main\": {\n" +
				"        \"temp\": -3.9,\n" +
				"        \"feels_like\": -8.44,\n" +
				"        \"temp_min\": -3.9,\n" +
				"        \"temp_max\": -3.9,\n" +
				"        \"pressure\": 1031,\n" +
				"        \"sea_level\": 1031,\n" +
				"        \"grnd_level\": 1016,\n" +
				"        \"humidity\": 82,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 804,\n" +
				"          \"main\": \"Clouds\",\n" +
				"          \"description\": \"overcast clouds\",\n" +
				"          \"icon\": \"04d\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 100\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 3.26,\n" +
				"        \"deg\": 133,\n" +
				"        \"gust\": 8.31\n" +
				"      },\n" +
				"      \"visibility\": 10000,\n" +
				"      \"pop\": 0,\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"d\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-17 06:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671267600,\n" +
				"      \"main\": {\n" +
				"        \"temp\": -2.23,\n" +
				"        \"feels_like\": -7.07,\n" +
				"        \"temp_min\": -2.23,\n" +
				"        \"temp_max\": -2.23,\n" +
				"        \"pressure\": 1029,\n" +
				"        \"sea_level\": 1029,\n" +
				"        \"grnd_level\": 1015,\n" +
				"        \"humidity\": 79,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 804,\n" +
				"          \"main\": \"Clouds\",\n" +
				"          \"description\": \"overcast clouds\",\n" +
				"          \"icon\": \"04d\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 100\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 4.06,\n" +
				"        \"deg\": 159,\n" +
				"        \"gust\": 11.1\n" +
				"      },\n" +
				"      \"visibility\": 10000,\n" +
				"      \"pop\": 0,\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"d\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-17 09:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671278400,\n" +
				"      \"main\": {\n" +
				"        \"temp\": -1.46,\n" +
				"        \"feels_like\": -6.59,\n" +
				"        \"temp_min\": -1.46,\n" +
				"        \"temp_max\": -1.46,\n" +
				"        \"pressure\": 1028,\n" +
				"        \"sea_level\": 1028,\n" +
				"        \"grnd_level\": 1014,\n" +
				"        \"humidity\": 82,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 804,\n" +
				"          \"main\": \"Clouds\",\n" +
				"          \"description\": \"overcast clouds\",\n" +
				"          \"icon\": \"04d\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 100\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 4.76,\n" +
				"        \"deg\": 161,\n" +
				"        \"gust\": 11.31\n" +
				"      },\n" +
				"      \"visibility\": 10000,\n" +
				"      \"pop\": 0,\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"d\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-17 12:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671289200,\n" +
				"      \"main\": {\n" +
				"        \"temp\": -1.34,\n" +
				"        \"feels_like\": -6.95,\n" +
				"        \"temp_min\": -1.34,\n" +
				"        \"temp_max\": -1.34,\n" +
				"        \"pressure\": 1026,\n" +
				"        \"sea_level\": 1026,\n" +
				"        \"grnd_level\": 1012,\n" +
				"        \"humidity\": 86,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 804,\n" +
				"          \"main\": \"Clouds\",\n" +
				"          \"description\": \"overcast clouds\",\n" +
				"          \"icon\": \"04n\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 100\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 5.63,\n" +
				"        \"deg\": 167,\n" +
				"        \"gust\": 13.2\n" +
				"      },\n" +
				"      \"visibility\": 10000,\n" +
				"      \"pop\": 0.28,\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"n\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-17 15:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671300000,\n" +
				"      \"main\": {\n" +
				"        \"temp\": -0.53,\n" +
				"        \"feels_like\": -6.25,\n" +
				"        \"temp_min\": -0.53,\n" +
				"        \"temp_max\": -0.53,\n" +
				"        \"pressure\": 1025,\n" +
				"        \"sea_level\": 1025,\n" +
				"        \"grnd_level\": 1011,\n" +
				"        \"humidity\": 93,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 600,\n" +
				"          \"main\": \"Snow\",\n" +
				"          \"description\": \"light snow\",\n" +
				"          \"icon\": \"13n\"\n" +
				"        },\n" +
				"        {\n" +
				"          \"id\": 511,\n" +
				"          \"main\": \"Rain\",\n" +
				"          \"description\": \"freezing rain\",\n" +
				"          \"icon\": \"13n\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 100\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 6.25,\n" +
				"        \"deg\": 180,\n" +
				"        \"gust\": 14.71\n" +
				"      },\n" +
				"      \"visibility\": 2637,\n" +
				"      \"pop\": 0.72,\n" +
				"      \"snow\": {\n" +
				"        \"3h\": 1.25\n" +
				"      },\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"n\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-17 18:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671310800,\n" +
				"      \"main\": {\n" +
				"        \"temp\": 0.18,\n" +
				"        \"feels_like\": -5.46,\n" +
				"        \"temp_min\": 0.18,\n" +
				"        \"temp_max\": 0.18,\n" +
				"        \"pressure\": 1023,\n" +
				"        \"sea_level\": 1023,\n" +
				"        \"grnd_level\": 1009,\n" +
				"        \"humidity\": 94,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 500,\n" +
				"          \"main\": \"Rain\",\n" +
				"          \"description\": \"light rain\",\n" +
				"          \"icon\": \"10n\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 100\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 6.5,\n" +
				"        \"deg\": 189,\n" +
				"        \"gust\": 15.3\n" +
				"      },\n" +
				"      \"visibility\": 10000,\n" +
				"      \"pop\": 1,\n" +
				"      \"rain\": {\n" +
				"        \"3h\": 1.31\n" +
				"      },\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"n\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-17 21:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671321600,\n" +
				"      \"main\": {\n" +
				"        \"temp\": 0.91,\n" +
				"        \"feels_like\": -4.21,\n" +
				"        \"temp_min\": 0.91,\n" +
				"        \"temp_max\": 0.91,\n" +
				"        \"pressure\": 1023,\n" +
				"        \"sea_level\": 1023,\n" +
				"        \"grnd_level\": 1009,\n" +
				"        \"humidity\": 95,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 500,\n" +
				"          \"main\": \"Rain\",\n" +
				"          \"description\": \"light rain\",\n" +
				"          \"icon\": \"10n\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 100\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 5.83,\n" +
				"        \"deg\": 202,\n" +
				"        \"gust\": 12.91\n" +
				"      },\n" +
				"      \"visibility\": 10000,\n" +
				"      \"pop\": 0.96,\n" +
				"      \"rain\": {\n" +
				"        \"3h\": 0.19\n" +
				"      },\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"n\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-18 00:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671332400,\n" +
				"      \"main\": {\n" +
				"        \"temp\": 1,\n" +
				"        \"feels_like\": -3.96,\n" +
				"        \"temp_min\": 1,\n" +
				"        \"temp_max\": 1,\n" +
				"        \"pressure\": 1022,\n" +
				"        \"sea_level\": 1022,\n" +
				"        \"grnd_level\": 1008,\n" +
				"        \"humidity\": 96,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 804,\n" +
				"          \"main\": \"Clouds\",\n" +
				"          \"description\": \"overcast clouds\",\n" +
				"          \"icon\": \"04n\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 100\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 5.55,\n" +
				"        \"deg\": 205,\n" +
				"        \"gust\": 12.11\n" +
				"      },\n" +
				"      \"visibility\": 10000,\n" +
				"      \"pop\": 0.08,\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"n\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-18 03:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671343200,\n" +
				"      \"main\": {\n" +
				"        \"temp\": 0.96,\n" +
				"        \"feels_like\": -3.5,\n" +
				"        \"temp_min\": 0.96,\n" +
				"        \"temp_max\": 0.96,\n" +
				"        \"pressure\": 1021,\n" +
				"        \"sea_level\": 1021,\n" +
				"        \"grnd_level\": 1007,\n" +
				"        \"humidity\": 97,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 804,\n" +
				"          \"main\": \"Clouds\",\n" +
				"          \"description\": \"overcast clouds\",\n" +
				"          \"icon\": \"04d\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 100\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 4.63,\n" +
				"        \"deg\": 192,\n" +
				"        \"gust\": 10.8\n" +
				"      },\n" +
				"      \"visibility\": 10000,\n" +
				"      \"pop\": 0.04,\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"d\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-18 06:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671354000,\n" +
				"      \"main\": {\n" +
				"        \"temp\": 1.4,\n" +
				"        \"feels_like\": -3.69,\n" +
				"        \"temp_min\": 1.4,\n" +
				"        \"temp_max\": 1.4,\n" +
				"        \"pressure\": 1019,\n" +
				"        \"sea_level\": 1019,\n" +
				"        \"grnd_level\": 1005,\n" +
				"        \"humidity\": 98,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 500,\n" +
				"          \"main\": \"Rain\",\n" +
				"          \"description\": \"light rain\",\n" +
				"          \"icon\": \"10d\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 100\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 6.03,\n" +
				"        \"deg\": 183,\n" +
				"        \"gust\": 13.8\n" +
				"      },\n" +
				"      \"visibility\": 2087,\n" +
				"      \"pop\": 0.52,\n" +
				"      \"rain\": {\n" +
				"        \"3h\": 0.25\n" +
				"      },\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"d\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-18 09:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671364800,\n" +
				"      \"main\": {\n" +
				"        \"temp\": 2.46,\n" +
				"        \"feels_like\": -3.16,\n" +
				"        \"temp_min\": 2.46,\n" +
				"        \"temp_max\": 2.46,\n" +
				"        \"pressure\": 1016,\n" +
				"        \"sea_level\": 1016,\n" +
				"        \"grnd_level\": 1002,\n" +
				"        \"humidity\": 96,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 501,\n" +
				"          \"main\": \"Rain\",\n" +
				"          \"description\": \"moderate rain\",\n" +
				"          \"icon\": \"10d\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 100\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 8.09,\n" +
				"        \"deg\": 190,\n" +
				"        \"gust\": 17.71\n" +
				"      },\n" +
				"      \"visibility\": 10000,\n" +
				"      \"pop\": 1,\n" +
				"      \"rain\": {\n" +
				"        \"3h\": 5.31\n" +
				"      },\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"d\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-18 12:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671375600,\n" +
				"      \"main\": {\n" +
				"        \"temp\": 2.87,\n" +
				"        \"feels_like\": -2.77,\n" +
				"        \"temp_min\": 2.87,\n" +
				"        \"temp_max\": 2.87,\n" +
				"        \"pressure\": 1014,\n" +
				"        \"sea_level\": 1014,\n" +
				"        \"grnd_level\": 1000,\n" +
				"        \"humidity\": 93,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 500,\n" +
				"          \"main\": \"Rain\",\n" +
				"          \"description\": \"light rain\",\n" +
				"          \"icon\": \"10n\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 100\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 8.5,\n" +
				"        \"deg\": 210,\n" +
				"        \"gust\": 17.5\n" +
				"      },\n" +
				"      \"visibility\": 8572,\n" +
				"      \"pop\": 0.8,\n" +
				"      \"rain\": {\n" +
				"        \"3h\": 2.06\n" +
				"      },\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"n\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-18 15:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671386400,\n" +
				"      \"main\": {\n" +
				"        \"temp\": 2.29,\n" +
				"        \"feels_like\": -2.4,\n" +
				"        \"temp_min\": 2.29,\n" +
				"        \"temp_max\": 2.29,\n" +
				"        \"pressure\": 1014,\n" +
				"        \"sea_level\": 1014,\n" +
				"        \"grnd_level\": 1000,\n" +
				"        \"humidity\": 98,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 501,\n" +
				"          \"main\": \"Rain\",\n" +
				"          \"description\": \"moderate rain\",\n" +
				"          \"icon\": \"10n\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 100\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 5.69,\n" +
				"        \"deg\": 219,\n" +
				"        \"gust\": 12.4\n" +
				"      },\n" +
				"      \"visibility\": 4924,\n" +
				"      \"pop\": 1,\n" +
				"      \"rain\": {\n" +
				"        \"3h\": 6.06\n" +
				"      },\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"n\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-18 18:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671397200,\n" +
				"      \"main\": {\n" +
				"        \"temp\": -0.39,\n" +
				"        \"feels_like\": -5.42,\n" +
				"        \"temp_min\": -0.39,\n" +
				"        \"temp_max\": -0.39,\n" +
				"        \"pressure\": 1015,\n" +
				"        \"sea_level\": 1015,\n" +
				"        \"grnd_level\": 1001,\n" +
				"        \"humidity\": 99,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 601,\n" +
				"          \"main\": \"Snow\",\n" +
				"          \"description\": \"snow\",\n" +
				"          \"icon\": \"13n\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 100\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 5.03,\n" +
				"        \"deg\": 341,\n" +
				"        \"gust\": 9.4\n" +
				"      },\n" +
				"      \"visibility\": 57,\n" +
				"      \"pop\": 1,\n" +
				"      \"snow\": {\n" +
				"        \"3h\": 5.75\n" +
				"      },\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"n\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-18 21:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671408000,\n" +
				"      \"main\": {\n" +
				"        \"temp\": -3.79,\n" +
				"        \"feels_like\": -10.67,\n" +
				"        \"temp_min\": -3.79,\n" +
				"        \"temp_max\": -3.79,\n" +
				"        \"pressure\": 1018,\n" +
				"        \"sea_level\": 1018,\n" +
				"        \"grnd_level\": 1004,\n" +
				"        \"humidity\": 92,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 601,\n" +
				"          \"main\": \"Snow\",\n" +
				"          \"description\": \"snow\",\n" +
				"          \"icon\": \"13n\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 100\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 6.77,\n" +
				"        \"deg\": 347,\n" +
				"        \"gust\": 12.81\n" +
				"      },\n" +
				"      \"visibility\": 296,\n" +
				"      \"pop\": 1,\n" +
				"      \"snow\": {\n" +
				"        \"3h\": 1.81\n" +
				"      },\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"n\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-19 00:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671418800,\n" +
				"      \"main\": {\n" +
				"        \"temp\": -4.78,\n" +
				"        \"feels_like\": -11.78,\n" +
				"        \"temp_min\": -4.78,\n" +
				"        \"temp_max\": -4.78,\n" +
				"        \"pressure\": 1021,\n" +
				"        \"sea_level\": 1021,\n" +
				"        \"grnd_level\": 1007,\n" +
				"        \"humidity\": 84,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 600,\n" +
				"          \"main\": \"Snow\",\n" +
				"          \"description\": \"light snow\",\n" +
				"          \"icon\": \"13n\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 100\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 7.01,\n" +
				"        \"deg\": 350,\n" +
				"        \"gust\": 14.02\n" +
				"      },\n" +
				"      \"visibility\": 10000,\n" +
				"      \"pop\": 0.52,\n" +
				"      \"snow\": {\n" +
				"        \"3h\": 0.38\n" +
				"      },\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"n\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-19 03:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671429600,\n" +
				"      \"main\": {\n" +
				"        \"temp\": -6.42,\n" +
				"        \"feels_like\": -13.42,\n" +
				"        \"temp_min\": -6.42,\n" +
				"        \"temp_max\": -6.42,\n" +
				"        \"pressure\": 1025,\n" +
				"        \"sea_level\": 1025,\n" +
				"        \"grnd_level\": 1010,\n" +
				"        \"humidity\": 83,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 804,\n" +
				"          \"main\": \"Clouds\",\n" +
				"          \"description\": \"overcast clouds\",\n" +
				"          \"icon\": \"04d\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 98\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 7.03,\n" +
				"        \"deg\": 345,\n" +
				"        \"gust\": 14.51\n" +
				"      },\n" +
				"      \"visibility\": 10000,\n" +
				"      \"pop\": 0.44,\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"d\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-19 06:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671440400,\n" +
				"      \"main\": {\n" +
				"        \"temp\": -7.16,\n" +
				"        \"feels_like\": -14.16,\n" +
				"        \"temp_min\": -7.16,\n" +
				"        \"temp_max\": -7.16,\n" +
				"        \"pressure\": 1028,\n" +
				"        \"sea_level\": 1028,\n" +
				"        \"grnd_level\": 1013,\n" +
				"        \"humidity\": 79,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 802,\n" +
				"          \"main\": \"Clouds\",\n" +
				"          \"description\": \"scattered clouds\",\n" +
				"          \"icon\": \"03d\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 28\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 6.74,\n" +
				"        \"deg\": 344,\n" +
				"        \"gust\": 14.3\n" +
				"      },\n" +
				"      \"visibility\": 10000,\n" +
				"      \"pop\": 0,\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"d\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-19 09:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671451200,\n" +
				"      \"main\": {\n" +
				"        \"temp\": -8.73,\n" +
				"        \"feels_like\": -15.73,\n" +
				"        \"temp_min\": -8.73,\n" +
				"        \"temp_max\": -8.73,\n" +
				"        \"pressure\": 1031,\n" +
				"        \"sea_level\": 1031,\n" +
				"        \"grnd_level\": 1016,\n" +
				"        \"humidity\": 80,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 801,\n" +
				"          \"main\": \"Clouds\",\n" +
				"          \"description\": \"few clouds\",\n" +
				"          \"icon\": \"02d\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 18\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 5.6,\n" +
				"        \"deg\": 343,\n" +
				"        \"gust\": 13.41\n" +
				"      },\n" +
				"      \"visibility\": 10000,\n" +
				"      \"pop\": 0,\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"d\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-19 12:00:00\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"dt\": 1671462000,\n" +
				"      \"main\": {\n" +
				"        \"temp\": -9.77,\n" +
				"        \"feels_like\": -16.77,\n" +
				"        \"temp_min\": -9.77,\n" +
				"        \"temp_max\": -9.77,\n" +
				"        \"pressure\": 1034,\n" +
				"        \"sea_level\": 1034,\n" +
				"        \"grnd_level\": 1019,\n" +
				"        \"humidity\": 83,\n" +
				"        \"temp_kf\": 0\n" +
				"      },\n" +
				"      \"weather\": [\n" +
				"        {\n" +
				"          \"id\": 800,\n" +
				"          \"main\": \"Clear\",\n" +
				"          \"description\": \"clear sky\",\n" +
				"          \"icon\": \"01n\"\n" +
				"        }\n" +
				"      ],\n" +
				"      \"clouds\": {\n" +
				"        \"all\": 7\n" +
				"      },\n" +
				"      \"wind\": {\n" +
				"        \"speed\": 4.82,\n" +
				"        \"deg\": 341,\n" +
				"        \"gust\": 12.4\n" +
				"      },\n" +
				"      \"visibility\": 10000,\n" +
				"      \"pop\": 0,\n" +
				"      \"sys\": {\n" +
				"        \"pod\": \"n\"\n" +
				"      },\n" +
				"      \"dt_txt\": \"2022-12-19 15:00:00\"\n" +
				"    }\n" +
				"  ],\n" +
				"  \"city\": {\n" +
				"    \"id\": 499068,\n" +
				"    \"name\": \"Samara Oblast\",\n" +
				"    \"coord\": {\n" +
				"      \"lat\": 53,\n" +
				"      \"lon\": 50\n" +
				"    },\n" +
				"    \"country\": \"RU\",\n" +
				"    \"population\": 3201272,\n" +
				"    \"timezone\": 14400,\n" +
				"    \"sunrise\": 1670993162,\n" +
				"    \"sunset\": 1671020591\n" +
				"  }\n" +
				"}";
		ForecastResponse weather = objectMapper.readValue(str, ForecastResponse.class);
		System.out.println(objectMapper.writeValueAsString(weather));

	}

}
