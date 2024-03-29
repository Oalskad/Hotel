USE [master]
GO
/****** Object:  Database [hotel]    Script Date: 3/16/2023 9:43:54 AM ******/
CREATE DATABASE [hotel]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'hotel', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.OALSKAD\MSSQL\DATA\hotel.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'hotel_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.OALSKAD\MSSQL\DATA\hotel_log.ldf' , SIZE = 73728KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [hotel] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [hotel].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [hotel] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [hotel] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [hotel] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [hotel] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [hotel] SET ARITHABORT OFF 
GO
ALTER DATABASE [hotel] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [hotel] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [hotel] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [hotel] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [hotel] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [hotel] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [hotel] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [hotel] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [hotel] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [hotel] SET  ENABLE_BROKER 
GO
ALTER DATABASE [hotel] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [hotel] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [hotel] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [hotel] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [hotel] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [hotel] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [hotel] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [hotel] SET RECOVERY FULL 
GO
ALTER DATABASE [hotel] SET  MULTI_USER 
GO
ALTER DATABASE [hotel] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [hotel] SET DB_CHAINING OFF 
GO
ALTER DATABASE [hotel] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [hotel] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [hotel] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [hotel] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'hotel', N'ON'
GO
ALTER DATABASE [hotel] SET QUERY_STORE = ON
GO
ALTER DATABASE [hotel] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [hotel]
GO
/****** Object:  Table [dbo].[admin]    Script Date: 3/16/2023 9:43:54 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[admin](
	[adminID] [int] NOT NULL,
	[adminName] [varchar](max) NULL,
	[adminPassword] [varchar](max) NULL,
	[adminRole] [varchar](max) NULL,
 CONSTRAINT [PK__admin__AD05008609F1C6E2] PRIMARY KEY CLUSTERED 
(
	[adminID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Coupons]    Script Date: 3/16/2023 9:43:54 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Coupons](
	[couponID] [varchar](50) NOT NULL,
	[name] [nvarchar](255) NULL,
	[discount] [float] NULL,
 CONSTRAINT [PK__Coupons__A2AF8D3498FE8D3E] PRIMARY KEY CLUSTERED 
(
	[couponID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[employee]    Script Date: 3/16/2023 9:43:54 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[employee](
	[employeeID] [varchar](50) NOT NULL,
	[fname] [nvarchar](255) NULL,
	[lname] [nvarchar](255) NULL,
	[phone] [int] NULL,
	[address] [nvarchar](255) NULL,
	[department] [nvarchar](255) NULL,
 CONSTRAINT [PK__employee__C134C9A147AE690E] PRIMARY KEY CLUSTERED 
(
	[employeeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Image]    Script Date: 3/16/2023 9:43:54 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Image](
	[roomID] [varchar](50) NULL,
	[imgSrc] [varchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Receipt]    Script Date: 3/16/2023 9:43:54 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Receipt](
	[receiptID] [varchar](50) NOT NULL,
	[couponID] [varchar](50) NULL,
	[cardNumber] [int] NULL,
	[servID] [varchar](50) NULL,
	[userID] [varchar](50) NULL,
	[roomID] [varchar](50) NULL,
	[detail] [varchar](50) NULL,
	[startDate] [date] NULL,
	[endDate] [date] NULL,
	[employeeID] [varchar](50) NULL,
	[finalPrice] [float] NULL,
 CONSTRAINT [PK__Receipt__CAA7E8988C199EC2] PRIMARY KEY CLUSTERED 
(
	[receiptID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Review]    Script Date: 3/16/2023 9:43:54 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Review](
	[reviewID] [varchar](50) NOT NULL,
	[receiptID] [varchar](50) NULL,
	[userID] [varchar](50) NULL,
	[roomID] [varchar](50) NULL,
	[description] [nvarchar](255) NULL,
	[rating] [int] NULL,
 CONSTRAINT [PK__review__2ECD6E2436CF2D09] PRIMARY KEY CLUSTERED 
(
	[reviewID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Room]    Script Date: 3/16/2023 9:43:54 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Room](
	[roomID] [varchar](50) NOT NULL,
	[status] [bit] NULL,
	[employeeID] [varchar](50) NULL,
	[dailyPrice] [float] NULL,
	[type] [varchar](50) NULL,
	[numberOfBed] [varchar](50) NULL,
	[bedType] [varchar](50) NULL,
	[description] [varchar](max) NULL,
 CONSTRAINT [PK__Room__6C3BF5DE53363CE1] PRIMARY KEY CLUSTERED 
(
	[roomID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[RoomType]    Script Date: 3/16/2023 9:43:54 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RoomType](
	[typeID] [varchar](50) NOT NULL,
	[name] [nvarchar](255) NULL,
	[dailyPrice] [float] NULL,
	[numberOfBed] [int] NULL,
	[bedType] [nvarchar](255) NULL,
	[description] [nvarchar](255) NULL,
 CONSTRAINT [PK__RoomType__F04DF11A594FFA30] PRIMARY KEY CLUSTERED 
(
	[typeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[service]    Script Date: 3/16/2023 9:43:54 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[service](
	[servID] [varchar](50) NOT NULL,
	[servName] [varchar](50) NULL,
	[price] [float] NULL,
	[desc] [varchar](50) NULL,
	[empID] [varchar](50) NULL,
 CONSTRAINT [PK_service] PRIMARY KEY CLUSTERED 
(
	[servID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 3/16/2023 9:43:54 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[userID] [varchar](50) NOT NULL,
	[username] [nvarchar](255) NOT NULL,
	[password] [nvarchar](255) NOT NULL,
	[fname] [nvarchar](255) NULL,
	[lname] [nvarchar](255) NULL,
	[dayOfBirth] [date] NULL,
	[visitFrequency] [int] NULL,
	[phoneNumber] [nchar](18) NOT NULL,
	[email] [nvarchar](255) NULL,
	[gender] [nvarchar](50) NULL,
 CONSTRAINT [PK__User__CB9A1CDF702A0E04] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[admin] ([adminID], [adminName], [adminPassword], [adminRole]) VALUES (1, N'Oalskad', N'Pugre11111', N'admin')
GO
INSERT [dbo].[Coupons] ([couponID], [name], [discount]) VALUES (N'CO001', N'WELCOME', 0.1)
INSERT [dbo].[Coupons] ([couponID], [name], [discount]) VALUES (N'CO002', N'HOTELDAY', 0.3)
INSERT [dbo].[Coupons] ([couponID], [name], [discount]) VALUES (N'CO003', N'HOTEL05', 0.5)
GO
INSERT [dbo].[employee] ([employeeID], [fname], [lname], [phone], [address], [department]) VALUES (N'EMP001', N'Huy', N'Long', 32912, N'Q7', N'Housekeeping')
INSERT [dbo].[employee] ([employeeID], [fname], [lname], [phone], [address], [department]) VALUES (N'EMP002', N'Kisa', N'Ta', 213123, N'Q8', N'Housekeeping')
INSERT [dbo].[employee] ([employeeID], [fname], [lname], [phone], [address], [department]) VALUES (N'EMP003', N'Mita ', N'Ya', 1231123123, N'Q8', N'Security')
GO
INSERT [dbo].[Image] ([roomID], [imgSrc]) VALUES (N'RO001', N'https://www.ahstatic.com/photos/7489_rokgb_00_p_1024x768.jpg')
INSERT [dbo].[Image] ([roomID], [imgSrc]) VALUES (N'RO001', N'https://www.ahstatic.com/photos/7489_rokgb_01_p_1024x768.jpg')
INSERT [dbo].[Image] ([roomID], [imgSrc]) VALUES (N'RO001', N'https://www.ahstatic.com/photos/7489_rokgb_02_p_1024x768.jpg')
INSERT [dbo].[Image] ([roomID], [imgSrc]) VALUES (N'RO001', N'https://www.ahstatic.com/photos/7489_rokgb_03_p_1024x768.jpg')
INSERT [dbo].[Image] ([roomID], [imgSrc]) VALUES (N'RO004', N'https://www.ahstatic.com/photos/7489_rotwa_00_p_1024x768.jpg')
INSERT [dbo].[Image] ([roomID], [imgSrc]) VALUES (N'RO004', N'https://www.ahstatic.com/photos/7489_rotwa_01_p_1024x768.jpg')
INSERT [dbo].[Image] ([roomID], [imgSrc]) VALUES (N'RO004', N'https://www.ahstatic.com/photos/7489_rotwa_02_p_1024x768.jpg')
INSERT [dbo].[Image] ([roomID], [imgSrc]) VALUES (N'RO003', N'https://www.ahstatic.com/photos/7489_rokga_00_p_1024x768.jpg')
INSERT [dbo].[Image] ([roomID], [imgSrc]) VALUES (N'RO003', N'https://www.ahstatic.com/photos/7489_rokga_01_p_1024x768.jpg')
INSERT [dbo].[Image] ([roomID], [imgSrc]) VALUES (N'RO003', N'https://www.ahstatic.com/photos/7489_rokga_02_p_1024x768.jpg')
INSERT [dbo].[Image] ([roomID], [imgSrc]) VALUES (N'RO002', N'https://www.ahstatic.com/photos/7489_roska_00_p_1024x768.jpg')
INSERT [dbo].[Image] ([roomID], [imgSrc]) VALUES (N'RO002', N'https://www.ahstatic.com/photos/7489_roska_04_p_1024x768.jpg')
INSERT [dbo].[Image] ([roomID], [imgSrc]) VALUES (N'RO005', N'https://www.ahstatic.com/photos/7489_rokgaef_00_p_1024x768.jpg')
INSERT [dbo].[Image] ([roomID], [imgSrc]) VALUES (N'RO005', N'https://www.ahstatic.com/photos/7489_rokgaef_01_p_1024x768.jpg')
INSERT [dbo].[Image] ([roomID], [imgSrc]) VALUES (N'RO005', N'https://www.ahstatic.com/photos/7489_rokgaef_02_p_1024x768.jpg')
GO
INSERT [dbo].[Receipt] ([receiptID], [couponID], [cardNumber], [servID], [userID], [roomID], [detail], [startDate], [endDate], [employeeID], [finalPrice]) VALUES (N'RC001', N'CO001', 9123123, NULL, N'US001', N'RO002', NULL, CAST(N'2023-01-19' AS Date), CAST(N'2023-01-22' AS Date), N'EMP001', 0)
INSERT [dbo].[Receipt] ([receiptID], [couponID], [cardNumber], [servID], [userID], [roomID], [detail], [startDate], [endDate], [employeeID], [finalPrice]) VALUES (N'RC002', N'CO001', 213123, NULL, N'US001', N'RO001', NULL, CAST(N'2020-01-22' AS Date), CAST(N'2020-01-26' AS Date), N'EMP002', 12.100000000000001)
INSERT [dbo].[Receipt] ([receiptID], [couponID], [cardNumber], [servID], [userID], [roomID], [detail], [startDate], [endDate], [employeeID], [finalPrice]) VALUES (N'RC003', N'CO001', 1231231, NULL, N'US001', N'RO002', NULL, CAST(N'2020-01-01' AS Date), CAST(N'2020-01-30' AS Date), N'EMP001', 145.1)
INSERT [dbo].[Receipt] ([receiptID], [couponID], [cardNumber], [servID], [userID], [roomID], [detail], [startDate], [endDate], [employeeID], [finalPrice]) VALUES (N'RC004', N'CO001', 65757, NULL, N'US001', N'RO001', NULL, CAST(N'2023-02-24' AS Date), CAST(N'2023-02-26' AS Date), N'EMP002', 6.1000000000000005)
INSERT [dbo].[Receipt] ([receiptID], [couponID], [cardNumber], [servID], [userID], [roomID], [detail], [startDate], [endDate], [employeeID], [finalPrice]) VALUES (N'RC005', N'CO001', 65757, NULL, N'US001', N'RO001', NULL, CAST(N'2023-02-24' AS Date), CAST(N'2023-02-26' AS Date), N'EMP002', 6.1000000000000005)
INSERT [dbo].[Receipt] ([receiptID], [couponID], [cardNumber], [servID], [userID], [roomID], [detail], [startDate], [endDate], [employeeID], [finalPrice]) VALUES (N'RC006', N'CO001', 123, N'SV003', N'US001', N'RO001', NULL, CAST(N'2023-03-27' AS Date), CAST(N'2023-03-29' AS Date), N'EMP002', 7)
INSERT [dbo].[Receipt] ([receiptID], [couponID], [cardNumber], [servID], [userID], [roomID], [detail], [startDate], [endDate], [employeeID], [finalPrice]) VALUES (N'RC007', N'CO001', 123123123, N'SV003', N'US001', N'RO001', NULL, CAST(N'2023-03-13' AS Date), CAST(N'2023-03-18' AS Date), N'EMP002', 16)
INSERT [dbo].[Receipt] ([receiptID], [couponID], [cardNumber], [servID], [userID], [roomID], [detail], [startDate], [endDate], [employeeID], [finalPrice]) VALUES (N'RC008', N'CO001', 123123, N'SV001', N'US001', N'RO002', NULL, CAST(N'2023-03-13' AS Date), CAST(N'2023-04-19' AS Date), N'EMP001', 30.5)
INSERT [dbo].[Receipt] ([receiptID], [couponID], [cardNumber], [servID], [userID], [roomID], [detail], [startDate], [endDate], [employeeID], [finalPrice]) VALUES (N'RC009', N'CO001', 21, N'SV002', N'US001', N'RO001', NULL, CAST(N'2023-03-13' AS Date), CAST(N'2023-03-16' AS Date), N'EMP002', 9.5)
INSERT [dbo].[Receipt] ([receiptID], [couponID], [cardNumber], [servID], [userID], [roomID], [detail], [startDate], [endDate], [employeeID], [finalPrice]) VALUES (N'RC010', NULL, 123123, N'SV001', N'US001', N'RO001', NULL, CAST(N'2023-03-13' AS Date), CAST(N'2023-03-25' AS Date), N'EMP002', 365)
INSERT [dbo].[Receipt] ([receiptID], [couponID], [cardNumber], [servID], [userID], [roomID], [detail], [startDate], [endDate], [employeeID], [finalPrice]) VALUES (N'RC011', NULL, 12312, N'SV001', N'US001', N'RO001', NULL, CAST(N'2023-03-13' AS Date), CAST(N'2023-03-23' AS Date), N'EMP002', 305)
INSERT [dbo].[Receipt] ([receiptID], [couponID], [cardNumber], [servID], [userID], [roomID], [detail], [startDate], [endDate], [employeeID], [finalPrice]) VALUES (N'RC012', N'CO001', 0, NULL, N'US001', N'RO002', N'', CAST(N'2005-03-25' AS Date), CAST(N'2005-03-25' AS Date), NULL, 50)
INSERT [dbo].[Receipt] ([receiptID], [couponID], [cardNumber], [servID], [userID], [roomID], [detail], [startDate], [endDate], [employeeID], [finalPrice]) VALUES (N'RC013', NULL, 9123123, NULL, NULL, N'RO001', NULL, CAST(N'2023-03-13' AS Date), CAST(N'2023-03-15' AS Date), N'EMP002', 61)
INSERT [dbo].[Receipt] ([receiptID], [couponID], [cardNumber], [servID], [userID], [roomID], [detail], [startDate], [endDate], [employeeID], [finalPrice]) VALUES (N'RC014', NULL, 123, N'SV001', N'US001', N'RO001', NULL, CAST(N'2023-03-13' AS Date), CAST(N'2023-03-15' AS Date), N'EMP002', 65)
INSERT [dbo].[Receipt] ([receiptID], [couponID], [cardNumber], [servID], [userID], [roomID], [detail], [startDate], [endDate], [employeeID], [finalPrice]) VALUES (N'RC015', N'CO001', 123123, N'SV003', N'US001', N'RO002', NULL, CAST(N'2023-03-13' AS Date), CAST(N'2023-03-15' AS Date), N'EMP001', 11)
INSERT [dbo].[Receipt] ([receiptID], [couponID], [cardNumber], [servID], [userID], [roomID], [detail], [startDate], [endDate], [employeeID], [finalPrice]) VALUES (N'RC016', N'CO001', 123123, N'SV003', N'US001', N'RO002', NULL, CAST(N'2023-03-13' AS Date), CAST(N'2023-03-15' AS Date), N'EMP001', 11)
INSERT [dbo].[Receipt] ([receiptID], [couponID], [cardNumber], [servID], [userID], [roomID], [detail], [startDate], [endDate], [employeeID], [finalPrice]) VALUES (N'RC017', N'CO001', 123123, N'SV003', N'US001', N'RO002', NULL, CAST(N'2023-03-13' AS Date), CAST(N'2023-03-15' AS Date), N'EMP001', 11)
INSERT [dbo].[Receipt] ([receiptID], [couponID], [cardNumber], [servID], [userID], [roomID], [detail], [startDate], [endDate], [employeeID], [finalPrice]) VALUES (N'RC018', N'CO001', 123123, N'SV003', N'US001', N'RO001', NULL, CAST(N'2023-03-13' AS Date), CAST(N'2023-03-16' AS Date), N'EMP002', 10)
INSERT [dbo].[Receipt] ([receiptID], [couponID], [cardNumber], [servID], [userID], [roomID], [detail], [startDate], [endDate], [employeeID], [finalPrice]) VALUES (N'RC019', N'CO001', 123123, N'SV001', N'US001', N'RO005', NULL, CAST(N'2023-03-14' AS Date), CAST(N'2023-03-16' AS Date), N'EMP001', 40.5)
INSERT [dbo].[Receipt] ([receiptID], [couponID], [cardNumber], [servID], [userID], [roomID], [detail], [startDate], [endDate], [employeeID], [finalPrice]) VALUES (N'RC020', NULL, 123123, N'SV003', N'US001', N'RO005', NULL, CAST(N'2023-03-15' AS Date), CAST(N'2023-03-17' AS Date), N'EMP001', 410)
INSERT [dbo].[Receipt] ([receiptID], [couponID], [cardNumber], [servID], [userID], [roomID], [detail], [startDate], [endDate], [employeeID], [finalPrice]) VALUES (N'RC021', N'CO001', 123123, N'SV003', N'US001', N'RO004', NULL, CAST(N'2023-03-15' AS Date), CAST(N'2023-03-17' AS Date), N'EMP003', 31)
INSERT [dbo].[Receipt] ([receiptID], [couponID], [cardNumber], [servID], [userID], [roomID], [detail], [startDate], [endDate], [employeeID], [finalPrice]) VALUES (N'RC022', NULL, 9123123, N'SV001', N'US001', N'RO003', NULL, CAST(N'2023-03-15' AS Date), CAST(N'2023-03-17' AS Date), N'EMP001', 305)
GO
INSERT [dbo].[Room] ([roomID], [status], [employeeID], [dailyPrice], [type], [numberOfBed], [bedType], [description]) VALUES (N'RO001', 1, N'EMP002', 100, N'Standard Double', N'2', N'Medium', N' A parlour or living room connected with to one or more bedrooms. (A room with one or more bedrooms and a separate living space.)

The room size or area of Suite rooms are generally between 70 m² to 100 m².')
INSERT [dbo].[Room] ([roomID], [status], [employeeID], [dailyPrice], [type], [numberOfBed], [bedType], [description]) VALUES (N'RO002', 1, N'EMP001', 180, N'President Suite', N'2', N'King-Size', N'The most expensive room provided by a hotel. Usually, only one president suite is available in one single hotel property. Similar to the normal suites, a president suite always has one or more bedrooms and a living space with a strong emphasis on grand in-room decoration, high-quality amenities and supplies, and tailor-made services (e.g. personal butler during the stay).

The room size or area of Presidential Suites are generally between 80 m² to 350 m².')
INSERT [dbo].[Room] ([roomID], [status], [employeeID], [dailyPrice], [type], [numberOfBed], [bedType], [description]) VALUES (N'RO003', 0, N'EMP001', 150, N'Premium Single', N'1', N'King-Size', N'Our Premium Single Rooms are generous in size, with plenty of room for you to personalise and accessorise your space.

While having the privacy of your own room is excellent, you will quickly discover that your wing and communal facilities play a big part in helping you meet your peers and develop new friendships.

Images are indicative only. Inclusions and layout of rooms may vary.')
INSERT [dbo].[Room] ([roomID], [status], [employeeID], [dailyPrice], [type], [numberOfBed], [bedType], [description]) VALUES (N'RO004', 0, N'EMP003', 150, N'Premium Double', N'2', N'King-Size', N'As a first year, international, study abroad or exchange student, living in a Premium Single Room is the surest way to make friends as you’ll have all your meals together in the Dining Hall every day. All our rooms are semi-furnished and professionally serviced weekly. Just bring your own linen and anything else you need to make your room home.')
INSERT [dbo].[Room] ([roomID], [status], [employeeID], [dailyPrice], [type], [numberOfBed], [bedType], [description]) VALUES (N'RO005', 0, N'EMP001', 200, N'Deluxe Single', N'1', N'King-Size', N'With graceful, simple and modern design, Deluxe rooms, which have a size of 32-34 m2, are each equipped with one King bed or two single beds, elegant furniture and a balcony. The bathrooms feature a modern standing shower, luxury amenities, and high quality towels. ')
GO
INSERT [dbo].[RoomType] ([typeID], [name], [dailyPrice], [numberOfBed], [bedType], [description]) VALUES (N'TYPE001', N'QueenSize', 100, 2, N'Queensize', N'yes')
GO
INSERT [dbo].[service] ([servID], [servName], [price], [desc], [empID]) VALUES (N'SV001', N'Buffet', 5, N'Combo Buffet', N'EMP003')
INSERT [dbo].[service] ([servID], [servName], [price], [desc], [empID]) VALUES (N'SV002', N'Ticket', 5, N'Park Ticket', N'EMP002')
INSERT [dbo].[service] ([servID], [servName], [price], [desc], [empID]) VALUES (N'SV003', N'Child-Care', 10, N'Child care', N'EMP003')
GO
INSERT [dbo].[User] ([userID], [username], [password], [fname], [lname], [dayOfBirth], [visitFrequency], [phoneNumber], [email], [gender]) VALUES (N'US001', N'Oalskad', N'Pugre11111', N'Huy', N'LOONG', CAST(N'2003-04-19' AS Date), 15, N'037557123         ', N'huylong2113@gmail.com', N'Male')
INSERT [dbo].[User] ([userID], [username], [password], [fname], [lname], [dayOfBirth], [visitFrequency], [phoneNumber], [email], [gender]) VALUES (N'US002', N'Mie', N'AI1234', N'Mie', N'Ai', CAST(N'2003-12-12' AS Date), 0, N'123               ', N'huylong2113@gmail.com', N'Female')
INSERT [dbo].[User] ([userID], [username], [password], [fname], [lname], [dayOfBirth], [visitFrequency], [phoneNumber], [email], [gender]) VALUES (N'US003', N'Komura', N'Pugre11111', N'Komura', N'Kaede', CAST(N'2013-12-02' AS Date), 0, N'0375578399        ', N'hu22ylong2113@gmail.com', N'Male')
INSERT [dbo].[User] ([userID], [username], [password], [fname], [lname], [dayOfBirth], [visitFrequency], [phoneNumber], [email], [gender]) VALUES (N'US004', N'Rikka', N'Pugre11111', N'Takanashi', N'Rikka', CAST(N'2003-02-03' AS Date), 0, N'0375578399        ', N'Rikka@gmail.com', N'Female')
INSERT [dbo].[User] ([userID], [username], [password], [fname], [lname], [dayOfBirth], [visitFrequency], [phoneNumber], [email], [gender]) VALUES (N'US005', N'qweqwe', N'1234', N'long', N'huy', CAST(N'2023-12-02' AS Date), 0, N'213123123         ', N'huylong2113@gmail.com', N'Male')
GO
ALTER TABLE [dbo].[Image]  WITH CHECK ADD  CONSTRAINT [FK__Image__roomID__489AC854] FOREIGN KEY([roomID])
REFERENCES [dbo].[Room] ([roomID])
GO
ALTER TABLE [dbo].[Image] CHECK CONSTRAINT [FK__Image__roomID__489AC854]
GO
ALTER TABLE [dbo].[Receipt]  WITH CHECK ADD  CONSTRAINT [FK__Receipt__couponI__4AB81AF0] FOREIGN KEY([couponID])
REFERENCES [dbo].[Coupons] ([couponID])
GO
ALTER TABLE [dbo].[Receipt] CHECK CONSTRAINT [FK__Receipt__couponI__4AB81AF0]
GO
ALTER TABLE [dbo].[Receipt]  WITH CHECK ADD  CONSTRAINT [FK__Receipt__employe__5165187F] FOREIGN KEY([employeeID])
REFERENCES [dbo].[employee] ([employeeID])
GO
ALTER TABLE [dbo].[Receipt] CHECK CONSTRAINT [FK__Receipt__employe__5165187F]
GO
ALTER TABLE [dbo].[Receipt]  WITH CHECK ADD  CONSTRAINT [FK__Receipt__roomID__49C3F6B7] FOREIGN KEY([roomID])
REFERENCES [dbo].[Room] ([roomID])
GO
ALTER TABLE [dbo].[Receipt] CHECK CONSTRAINT [FK__Receipt__roomID__49C3F6B7]
GO
ALTER TABLE [dbo].[Receipt]  WITH CHECK ADD  CONSTRAINT [FK__Receipt__userID__48CFD27E] FOREIGN KEY([userID])
REFERENCES [dbo].[User] ([userID])
GO
ALTER TABLE [dbo].[Receipt] CHECK CONSTRAINT [FK__Receipt__userID__48CFD27E]
GO
ALTER TABLE [dbo].[Review]  WITH CHECK ADD  CONSTRAINT [FK__review__receiptI__4CA06362] FOREIGN KEY([receiptID])
REFERENCES [dbo].[Receipt] ([receiptID])
GO
ALTER TABLE [dbo].[Review] CHECK CONSTRAINT [FK__review__receiptI__4CA06362]
GO
ALTER TABLE [dbo].[Review]  WITH CHECK ADD  CONSTRAINT [FK__review__userID__4BAC3F29] FOREIGN KEY([userID])
REFERENCES [dbo].[User] ([userID])
GO
ALTER TABLE [dbo].[Review] CHECK CONSTRAINT [FK__review__userID__4BAC3F29]
GO
ALTER TABLE [dbo].[Room]  WITH CHECK ADD  CONSTRAINT [FK__Room__employeeID__236943A5] FOREIGN KEY([employeeID])
REFERENCES [dbo].[employee] ([employeeID])
GO
ALTER TABLE [dbo].[Room] CHECK CONSTRAINT [FK__Room__employeeID__236943A5]
GO
ALTER TABLE [dbo].[Room]  WITH CHECK ADD  CONSTRAINT [FK__Room__employeeID__5070F446] FOREIGN KEY([employeeID])
REFERENCES [dbo].[employee] ([employeeID])
GO
ALTER TABLE [dbo].[Room] CHECK CONSTRAINT [FK__Room__employeeID__5070F446]
GO
USE [master]
GO
ALTER DATABASE [hotel] SET  READ_WRITE 
GO
