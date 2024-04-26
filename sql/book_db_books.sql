-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: book_db
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `book_id` varchar(10) NOT NULL,
  `title` varchar(10) NOT NULL,
  `auther` varchar(10) DEFAULT NULL,
  `price` int NOT NULL,
  `type_id` int NOT NULL,
  `publisher` varchar(8) NOT NULL,
  `year` date NOT NULL,
  `ex` varchar(1000) NOT NULL,
  `other` varchar(1000) DEFAULT NULL,
  `delete_flag` int NOT NULL DEFAULT '0',
  `insert_id` int NOT NULL,
  `insert_day` date NOT NULL,
  `update_id` int DEFAULT NULL,
  `update_day` date DEFAULT NULL,
  `delete_id` int DEFAULT NULL,
  `delete_day` date DEFAULT NULL,
  `photo` longblob,
  UNIQUE KEY `title_UNIQUE` (`title`),
  KEY `type_id_idx` (`type_id`),
  CONSTRAINT `type_id` FOREIGN KEY (`type_id`) REFERENCES `types` (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES ('BK031401','aaaa','aaa',222,301,'aaaa','2024-03-08','ã‚ã‚ã‚','',0,24020801,'2024-03-14',24032101,'2024-04-25',NULL,NULL,_binary '‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0d\0\0\0d\0\0\0p\â•T\0\0\0	pHYs\0\0\Ä\0\0\Ä•+\0\0\0;tEXtComment\0xr:d:DAF8pa5Uxko:2,j:4617734041673085697,t:24021305_\ìŒ\0\0öiTXtXML:com.adobe.xmp\0\0\0\0\0<x:xmpmeta xmlns:x=\'adobe:ns:meta/\'>\n        <rdf:RDF xmlns:rdf=\'http://www.w3.org/1999/02/22-rdf-syntax-ns#\'>\n\n        <rdf:Description rdf:about=\'\'\n        xmlns:dc=\'http://purl.org/dc/elements/1.1/\'>\n        <dc:title>\n        <rdf:Alt>\n        <rdf:li xml:lang=\'x-default\'>åç§°æœªè¨­å®šã®ãƒ‡ã‚¶ã‚¤ãƒ³ - 1</rdf:li>\n        </rdf:Alt>\n        </dc:title>\n        </rdf:Description>\n\n        <rdf:Description rdf:about=\'\'\n        xmlns:Attrib=\'http://ns.attribution.com/ads/1.0/\'>\n        <Attrib:Ads>\n        <rdf:Seq>\n        <rdf:li rdf:parseType=\'Resource\'>\n        <Attrib:Created>2024-02-13</Attrib:Created>\n        <Attrib:ExtId>d7081fe4-2fe2-495d-8c63-9cb4b4018e34</Attrib:ExtId>\n        <Attrib:FbId>525265914179580</Attrib:FbId>\n        <Attrib:TouchType>2</Attrib:TouchType>\n        </rdf:li>\n        </rdf:Seq>\n        </Attrib:Ads>\n        </rdf:Description>\n\n        <rdf:Description rdf:about=\'\'\n        xmlns:pdf=\'http://ns.adobe.com/pdf/1.3/\'>\n        <pdf:Author>Yun Sedun</pdf:Author>\n        </rdf:Description>\n\n        <rdf:Description rdf:about=\'\'\n        xmlns:xmp=\'http://ns.adobe.com/xap/1.0/\'>\n        <xmp:CreatorTool>Canva</xmp:CreatorTool>\n        </rdf:Description>\n        \n        </rdf:RDF>\n        </x:xmpmeta>\ï\0\0>IDATxœ\İ]iXW\Ö~\éFAŒ\èˆ,†]D;ˆ\nF\Z5\"‹\n˜L\\P\Ã\Äèˆ¢š\Í’1†(Œ1 [PBj@pA°\Ãbºq‚Di´A–\ïOóÔ­î®®n4\ïóğƒ:÷s»NU\İ{\Ïvµº»»»ñ£±±w\î\ÜAEE„B!*++\Ñ\Ø\Ø‰D‚––H$<zô\0`ddCCC6†††3f\ì\í\íaooGGG\Ø\Û\Ûcô\èÑƒü‹\è¡õ¼)D,#;;\0\0b±˜Uş–––\àóùğññŸÏ‡™™«üUÅ +¤««EEEHJJBjj**++5*üøñDPPx<´´´4*ÿYšBD\"=ŠcÇ\á\îİ»ƒ1„°µµEXX\Â\Â\Â`bb2(cĞ¸B\îŞ½‹?üñññxúô©&E+]]]„‡‡#22¦¦¦\Z•­1…Ü¾}ûö\í\ÃÉ“\'Ÿ[E<===¬\\¹›7o\Æ\Ë/¿¬™jW\Èıû÷…o¾ùF%>fffprr‚¥¥%ÆŒ;zzzı\ÚI¥RˆD\"ˆ\ÅbˆD\"üşû\ï(//GCCc\Ù\\.\ë×¯Ç®]»0|øp•~‡<¨U!_~ù%¢££\Ñ\ÜÜ¬t\ß)S¦`Îœ9ğòò‚‡‡ŒU\ZKSS\n‘ŸŸ‹/\âÚµkJó011Á\Z\Zª\ÒX\è ……B¼õ\Ö[¸r\åŠ\Â}ttt0{öl,\\¸~~~j_ŠD\"¤§§#99\Ù\Ù\Ù\è\è\èP¸¯\â\ã\ãaaaÁú¸XWÈ™3g°zõjH$…Ú\Z5\nÿûß±v\íZO 2ˆ\Åb\Ä\Ä\Ä\àÈ‘#øó\Ï?\ê3r\äHœ>}\Zs\æ\Ìau,¬)D*•bÓ¦Mø\ïÿ«P{[[[üóŸÿ\Äò\åË¡¯¯\Ï\ÆT†D\"Á7\ß|ƒ\Ï>ûL¡¥8‡\ÃÁö\íÛ±k\×.hkk³2VR[[‹ÀÀ@Ü¸qCn[;;;|üñ\ÇX¸p!¸\\®ª¢Õ‚§OŸ\"11\ï¿ÿ>D\"‘\ÜöHNN\ÆÈ‘#U–­²BJKK\á\ë\ë‹{÷\îÑ¶\Ó\Ñ\ÑATT\"##¡«««ŠHttt@(¢¼¼÷\î\İ\ëıÌ¼ô\ÒK3fœagg§²\Â[[[±s\çN<x´mğ\ã?bÜ¸q*\ÉTI!yyyğóóCKKm;OOO\Ä\Å\ÅÁÁÁ©(TWW\ãÄ‰\È\Í\ÍEQQ?~L\Û\ŞÀÀ\0\àóù\r\r…µµ5cÙ¥¥¥“»2333CVVÆ\ÏXc…dff\"((O<!¶\ár¹ø×¿ş…\íÛ·ƒ\Ã\á0\Z`JJ\nö\ïßK—.1\ê/\Ã\ìÙ³???Fı\Û\Û\Û…ıû÷Ó¶366†@ €««+#9Œ\"\à\ç\ç©TJlcnnÓ§O\Ã\ËË‹\ÑÀ\nñ\î»ï¢¬¬ŒQx<¾ú\ê+¸¹¹1êŸ––†eË–\Ñ\î­F‰K—.1zS”V\ÈÕ«WÁ\çói—µ3f\Ì@RRşö·¿)= öövlÛ¶\rTº¯¢\àr¹Øºu+ö\ì\Ù\Ãh©­­E@@\0nŞ¼IlcjjŠ¢¢\"XZZ*\Å[)…\Ô\ÕÕ\Ç\ã\ÑN\à‹/FBB£‰[,cÑ¢Eøõ\×_•\î\Ë8w\î#§\ÕÃ‡±p\áBüüó\Ï\Ä6®®®\È\ÏÏ‡¡¡¡\Â|VÈ“\'O\à\éé‰’’b›·\ŞzñññŒºòòrÌ›7O¡e¦–––=z4º»»qÿş}ˆD\"tuu)\Ì\Ã\Ö\Ö.\\`d<|üø1‘Ml³h\Ñ\"üğ\Ã\nóTX!Ë–-CBB‘\Z\ZŠ\ãÇ3şL›6M\î\Ò\è™‚ƒƒ\á\í\í\rWWWJ\ãbii)rrrğı÷\ß\Ó>@2X[[£¨¨ˆ‘\äÉ“\'ğóóCNN±Í‡~ˆ¨¨(…ø)¤£GbÕªUDzpp0\íV[ZZ\à\îîŠŠ\n\Úv‹/FTT&Mš¤ÿ\â\âb\ìİ»\É\ÉÉ´\íx<òòò(X´¶¶b\îÜ¹ø\å—_(\é999˜9s¦\\^rR]]\rWWW\â$>{öl¤§§CGGG¡÷Gww7‚ƒƒ‘””Dlcff†\Ä\ÄDÆ«5²²²°t\éRü\ïÿ#¶	\Ç\áÃ‡ñonn\ÆÌ™3‰½••nÜ¸aÃ†\Ñò¡UHWWfÎœ‰‚‚Jº­­-JJJ\ä\n!\áØ±c#\Ò\'OŒ´´4\Ö,¿µµµ˜?>nß¾Mlsşüy2\â/‰0i\Ò$<xğ€’¾j\Õ*\Ä\Å\Å\Ñò UHll,Ö¯_OI\Ó\Õ\ÕEQQ‘ÒŸ>|{{{Ü¿Ÿ’>}útdff2V6	<€··7®_¿NI·±±Á­[·›w\Ò\Ò\Ò@¤gggƒ\Ï\ç\é\Ä\ís]]\íDô\ÙgŸ1V\0ü\ç?ÿ!*\Ã\Î\Î©©©¬+\è\ÙIgff}UUUøú\ë¯ó÷÷÷\ÇÆ‰ôğğp\Ú\r5ñ\rY²d	Îœ9C\Ù)88\ßÿ½’Cı477\Ã\ÚÚº7À­/ğë¯¿\Â\ÑÑ‘1Ep\å\ÊÌ˜1ƒ\Ò1eff†šš\ZFó\"\Ğc-6m\ZŠ‹‹)\é»w\ï\Æ|@I£|C\n‰\Ê022BLL£Ê@© g°\êV\0¸»»cÓ¦M”´úúz¤¤¤0\æ=d\È>|˜h¿ûøã‰_\Ê»w\ï&\nÛ½{·Ê½\ãÇS^777Çºu\ëT\â­¢¢¢ˆA¤1*\n‡ğğpJÚ“\'OˆF\ÊŸ¬«W¯\Â\İİ²ñÄ‰Q\\\\¬’w¬¡¡¸jú\ä“O°m\Û6Æ¼™`\ãÆ”v3===<|øñg\èY@\Ø\ÛÛ£©©i\0\Í\Ğ\ĞµµµœZŞ>úˆ(\àÀ*»*‘¶t\éR•x3)‚D*•¢°°P%\Ş\Æ\Æ\ÆØ±c%M\"‘ 66vÀõ~\n\n…8ş<%oooøøø¨4@ \ç\r¤‚‹‹‹Z¢8\ä\Ç\ã]¯l9\Ã\ÃÃ‰¿+&&mmmı®õSH\\\\H\ÛEm1ò@2‘xzz²\Â_YhiiaÚ´i”4y\æE ««K\\<455\r0\éô*¤³³\ß~û-eGÌ=[\åÁ=û*899±ÂŸ	H²\Ù\n_µjqOõ\ì=\ïUHvv6\Z);½÷\Ş{¬\0qS¤ŒÏ€mVüñ+üŒŒˆó\ãÅ‹û-{r\ê\Ô)\Êúúúxó\Í7Y\0¢¯B\Û =½ò‚7”Á\êÕ«)¯wvvö\Ûóq€°\Z\Òd###\ÖFZ÷·¶¶²&CYd³ù»§L™Bô±÷u`q€9)„ò7\Ş`mP@O\ìT‰NW¤ymÄˆ¬\Ê!}i\n\n\nz\ßF\0\\¸p²¡ë±«cÇ¥¼~\ë\Ö-V\å(’ƒ4V¦X°`\åõ§OŸöz9\0ˆ1O\Ş\Ş\Ş*\íT©@ŠW\Ê\Ë\Ë”y¤³³ùùù”4U¬\ÙT˜0aq‘——\0à´µµ7kl¿@Ï·”\nşù\'ñÆ¨€8yóx<Veiii}!2\' \ç\æÍ›Ä¥(iÃ¤\n¦OŸNœ\Ø\é‚(\Ô’\Ñ\Ø\ØS§Ne]\Şô\é\Ó)¯_»v\r\à\"\ÖuuuYe\Ó4É£– P\ä	[¨­­Ebb\"%mÁ‚¬¥ôI\ÉR©UUU\à”——S6pvvÆ!CX\Ğ¿E…¶¶6lÙ²E-2©°q\ãFb\æ\Ô\Ûo¿­™\Î\Î\ÎD?É­[·À©®®¦$N˜0A-€\×^{\r...”´\'N\à\ìÙ³j“-Ã±cÇˆ¡A<\Ş\Ş\Şj‘«§§[[[JZMM\r8555”DR\'¶@g¬\\¹r¥BnLq\é\Ò%¼û\î»D:[†THQ’w\ï\Ş‡´!³²²Rç˜°d\ÉÌ˜1ƒ’\Ö\Ú\Ú\n___bdˆ*¸r\å\n,X0À\ì-ƒ-ZÄºÜ¾ \İ\Û{÷\îC2 1‰\\W_~ù%1ôôşıûğòò\ÂO?ıÄš¼\ä\ädÌš5‹h•\Ğ\Ñ\ÑÁ_|Áš<F\ZEy½©©	RU6ò\å\äa\âÄ‰´	0=‚¯¯/>ú\è#\â­Z[[±u\ëV,Z´ˆ6Á(66V¥,/EAº·MMM\ä¸,MU\ÅÙ°a–-[F¤wtt\àı÷ß‡­­->ÿüs…Ó–óù¾}û`ccƒÿûß´m\ß{\ï=¬Y³FaŞª€N!Z\0(]„ùùù\Äo<\ÛhooGHHRSSå¶•˜5k&O;;;˜˜˜ ³³¨¬¬DII	rss\å&k=Ô“\'Oj,+8##ƒ2µN__\Ú\\.—rĞš4‡\ë\è\è\à\ìÙ³Fzz:m\Ûöövddd ##ƒÙ¯¿ş:Nœ8¡\ÑmÒ†³½½’ñP\Óş	]]]œ?Û¶m\Ó\È\çRKK\Ñ\Ñ\Ñ8}ú´Zv\ät e\è\ê\ê‚C\n*‡—\ËÅŠ+\'d*777,]º”qv°* \İ[===pH#Ek•°…«W¯\"  \0NNNÄ˜X6Q\\\\\'\'\'jD^_¬\Ë#FŒ\0‡4\ãkÊƒwûöm\Ã\İ\İiii\Z‘\Ù©©©\àñxxıõ\×q\ç\Î\È$\İ\ÛQ£F3f\ÌJ\"É¤\Â¤R)\"\"\"\à\â\â¢TR¤ºpö\ìY8;;có\æ\ÍhooW«,’ı\Ğ\Ô\ÔÚ¤’\êTHYYBCCA²4“ ££\Ø\Û\Û\Ã\Æ\Æ\æ\æ\æ000\è\r!’H$hmmE]]ªªªPYY‰Ë—/+|ƒ;::°ÿ~dee\áÔ©SpvvVú·)’BÆGVHUU•Z‹Í›7+¼ó1b/^ğù|(%O\"‘@  %%\çÎShcyıúuğx<\Ä\Æ\Æ\Ò&»2\éŞ7Z\İó\çÏ§lP__\ÏZQ±\î\înlŞ¼P¨ı¼yó°~ızÌ™3‡5¿L{{;.\\¸€C‡\Ñ\æ–÷Ett4ö\ì\ÙÃŠ| \'‘T\İ!;;’_\0ŠŠŠXDWW\Şy\ç…”\á\ïï²²2üøã˜?>«N2à§Ÿ~Bqq1\æÎ+·\ÏŞ½{±a\ÃbÌ³² ‹¨Ÿ8q\"8\Ä\Ò—/_feŠdŸZ[[#==©©©˜8q\"+r\é\à\æ\æ†.\àÜ¹sr£\î?ÿüsü\ãÿ`E.\é!·²²\êYe\ä\ÈsYhŠ*ˆˆˆ@||<m›7\Şx×¯_\éÓ©N\áÆ´™³@\Ï\Ü\ÇÆ§‹tOe:\à\0 \Z‹ŠŠT\n:ø\â‹/p\è\Ğ!\"\Ë\å\"&&‰‰‰jÉ¸U/½ôRRRğ\É\'ŸĞšmv\ìØ¡RdŒH$\"\æœÈª<p€	”\n]]]´Uè••…\r6\éC‡EJJŠFs\n\åaÛ¶mø\î»\ïhs\Ô×¬Y£TùÛ¾ \Ûo\ÉtÀzN \ÍüL6m\r\r\r\r\r%š¾‡\r†\ì\ì\ìAùD\ÉCHH222ˆ5O\Ú\Ú\Ú‚‡*Í›”J\Ş÷ş÷ZÖ‚ƒƒ)¥J&@XX1·\ÂÀÀ\0\é\é\éğğğPŠ§&Á\çóñ\Ã?\ÃhE\"±\Â	UUU\Ä%}\ï}¯BH‘\Ù]]]8r\äˆÂ‚OŸ>\Ì\ÌLJš–––Jeÿ4	___ÚŠ			´	¬\Ï\âğ\á\ÃÄ¥s\ß\Ä\Ó~i\Ñ”6ˆD\"¹{‚\Ö\ÖV\Ø\ÛÛ£¾¾’¾u\ëV|ú\é§\nı€\ç\ï¼óQ1\Î\Î\Î(++“\ëÜ’J¥°°° L~\å•Wú\ÍIıœË—/§d\Ø\ØØ¨\Ğ\\rğ\àA¢2\Ü\İ\İiS®ŸW:tvvv”´[·nó2û\âÔ©S”\Ê\0FHö{C\Äb1ÆG^\é\èèˆ›7oŸ†\æ\æfXZZRúQ¸\\.Š‹‹—Nl\ä\æ\æbÖ¬Y”4TWW¿\í\í\íppp@mm\í\0š¾¾>\Äbq¿“ú½!Ä¹¤¢¢‚öiˆ‹‹#:µ\"\"\"^Xe\0À«¯¾JŒõ‹\Åø\î»\ïˆ}¿ú\ê+Je\0=Ÿ\Ãg\áPZ£¼¼œhv¶°°€P(°$\ì\êê‚µµ5\åjlØ°a¨©©\ÑHœ—:Q]]\rGGG\ÊÓ¦NJi‘H$°±±¡,43d\È\Ô\Ô\ÔÀ\ÜÜ¼\ßõ\åñ\ã\Ç#((ˆrPb±{÷\îp=\'\'‡¸4Ş°a\Ã¯ \'—4\Ç^¾|B¡pÀõ\è\èhbÕŸ+VP@¨—UZZŠÉ“\'S2\Ò\Ö\ÖFiii¿·hÕªU8zô(eÛººº\çş0GEqó\æMb\ÔşÎ;±k×®\Şÿ¯^½\n\Ê4=mmm…B\Êzô”!“&M\">\rı\Êutt\Í+e\0=)\Z¤\rm\ß{ğô\éS¬^½š˜3A<€³o\ß>b\nsAAA\ï¶  €X}ÅŠ$ö/,Ha¯×¯_ï¼w\ì\ØAŒ\Ü777\ÇÎ;‰üi‹`\Æ\Å\Å\ã]¹\\.\n9€®££ƒ(\ír}\Şñû\ï¿\Ó	\â\â\â`ee…¹s\çw\å)))´¦~¹u{½½½‰õ\ÍeG\ÙQ¹C\çÌ™ƒ‹/Ò±~a\á\ì\ìL 1o\Ş<\\»vX3\æ\Í7\ß$–0‘An\Ø^||<±\ÄD}}=\Ñ7=X\å–4R&mff&Qfff”Ë…\\…XYY)\Ä\èY\Ğù\ê_t0É¿<zô¨Bg1*\Øúö\Ûo\ÓV ¦\Â_Y!\Êş¶\è\èh¼ö\Úk\nµUøt©T\nOOO…\ã`[ZZµ–:Q]]\r…\Úúúú\"--M\á n¥tihhÀ+¯¼B¬#ƒ¶¶ös\01´µµ)tŠÂ„	ğ\Ë/¿(/ T,¾©©)’““\å>ù\Ú\Ú\ÚDƒ\Ú_\r\r\rr‹ò˜˜˜ %%E\é\à\r¥“#x<ÎŸ?O •J\á\æ\æ&7\êEDzz:\Ü\Ü\Üh\ã…GŒ‹/2:ÓQ¶\nŸ\ÏGRR\ík\Û\Ü\Ülß¾ı/ñù’V\æ\ï\ïO{B›±±1²²²û©t°dnn.üıı\å&÷¸¸¸\àÈ‘#\Ïu`\n±f\Í\Z¹E\ÖLLL••¥\Ò\nS¥|®W_}¹¹¹r\Ïnºq\ãfÌ˜õ\ë\×+•\Ö<\Øhnn\ÆÚµk\á\é\é)W(,,Ty¹\Ï\Ê\á\Ä\Õ\ÕÕ˜?>*++\å¶566Fdd$Ö­[÷Üœı,?~Œ˜˜|úé§´Ÿ\'\Ø<œ˜•ŒÇ—_~%%%\n\åR<xğ\0[·n…­­-bcc5\ËH‡G\áĞ¡C°±±Add¤\\ep¹\\|ğÁøù\çŸYsÂ±~Àı‰\'.÷ğ`†°°0¬[·\ÑY‚l@(\"&&ñññ\n\×\ê=z4Y/\ãÄºB€9cùò\årOW\î‡///,Y²!!!\Ä-l¡±±gÏÅ™3gPPP Tş\ÇÜ¹sq\ì\Ø1\Ö+\ëµ(\è©öƒ;v(]!Z[[^^^˜:u*¦L™777•ß\ß~û\r\Å\Å\Å())Á\åË—‘ŸŸ¯PÙ¾055Å°d\É•\ÆBµ)D†††lÙ²\'OT‰\Ïğ\á\Ã\á\ä\ä\'\'\'8::\Â\Ô\Ôzzz\Ğ\××‡º»»!•J{ÿ\ê\ê\êPQQòòrTTT¨T6\\[[Ø¹s§\Ú\ísjWˆeeeØ·oÎœ9£ô“9X:t(V¯^M›6©½ ›\ZSˆB¡{ö\ìÁ©S§[\Å:k×®Å–-[4¤¡q…\ÈPUU…¸¸8?~œ¬i899a\åÊ•X±b…F*\êQa\Ğ\"Cgg\'òòò””„””[‰]]]ˆ   µ\Ô)Vƒ®gñ\Ûo¿A @  \'\'‡ù\Ç¶¶¶ğööŸÏ‡Ï ½	$<w\nyõõõ¨¨¨@ee%\îÜ¹ƒ;w\î\à?ş@KK$	$I\ï\n\Ê\È\ÈFFF044„‘‘ÆŒ;;;899Á\Ş\Ş\nùµÿœº‘¡<\ØÁ\0\0\0\0IEND®B`‚'),('BK24031801','aaaaaaa','aaaa',20000,301,'ã‚ã‚ã‚ã‚ã‚','2024-03-08','test','',0,24020801,'2024-03-18',24032101,'2024-04-23',NULL,NULL,NULL),('BK022801','ãƒ†ã‚¹ãƒˆ','ãƒ†ã‚¹ãƒˆ',1000,305,'ãƒ†ã‚¹ãƒˆ','2024-02-28','æ›´æ–°ãƒ†ã‚¹ãƒˆaaaaaaaaa','aa',0,24020801,'2024-03-18',24032101,'2024-04-25',NULL,NULL,NULL),('BK031301','ãƒ†ã‚¹ãƒˆ2','ãƒ†ã‚¹ãƒˆ2',1000,301,'ãƒ†ã‚¹ãƒˆ','2024-03-13','aaaaa',NULL,0,24020801,'2024-03-13',NULL,NULL,NULL,NULL,NULL),('BK031302','ãƒ†ã‚¹ãƒˆ3','ãƒ†ã‚¹ãƒˆ3',10000,301,'ãƒ†ã‚¹ãƒˆ','2024-03-13','æ›´æ–°ãƒ†ã‚¹ãƒˆ','',0,24020801,'2024-03-18',24020801,'2024-03-18',NULL,NULL,NULL),('BK031303','ãƒ†ã‚¹ãƒˆ4','ãƒ†ã‚¹ãƒˆ3',10000,301,'ãƒ†ã‚¹ãƒˆ','2024-03-13','aaaaaa','',0,24020801,'2024-03-18',NULL,NULL,NULL,NULL,NULL),('BK24031501','ãƒšãƒ¼ã‚¸ãƒ³ã‚°ãƒ†ã‚¹ãƒˆï¼‘','ãƒšãƒ¼ã‚¸',11111,301,'ãƒ‘ãƒ–ãƒªãƒƒã‚·ãƒ¥','2024-03-13','','',0,24020801,'2024-03-18',NULL,NULL,NULL,NULL,NULL),('BK24031502','ãƒšãƒ¼ã‚¸ãƒ³ã‚°ãƒ†ã‚¹ãƒˆï¼“','è¿½åŠ ãƒ†ã‚¹ãƒˆ',20000,301,'ãƒ‘ãƒ–ãƒªãƒƒã‚·ãƒ¥','2024-03-13','','',0,24020801,'2024-03-15',NULL,NULL,NULL,NULL,NULL),('BK24042501','ãƒãƒ¼ãƒˆãƒ•ã‚©ãƒªã‚ª','æ›¸ç±å¤ªéƒ',2000,301,'SDå‡ºç‰ˆ','2020-03-08','test','',0,24032101,'2024-04-25',24032101,'2024-04-25',NULL,NULL,NULL),('BK031501','ç¢ºèªç”»é¢ãƒ†ã‚¹ãƒˆ','ç¢ºèªè€…',20000,301,'ãƒ‘ãƒ–ãƒªãƒƒã‚·ãƒ¥','2024-03-08','','',0,24020801,'2024-03-15',NULL,NULL,NULL,NULL,NULL),('BK031304','è¿½åŠ ãƒ†ã‚¹ãƒˆ','è¿½åŠ ãƒ†ã‚¹ãƒˆ',20000,301,'ãƒ‘ãƒ–ãƒªãƒƒã‚·ãƒ¥','2024-03-08','aaaa','aaaaa',0,24020801,'2024-03-13',NULL,NULL,NULL,NULL,NULL),('BK031305','è¿½åŠ ãƒ†ã‚¹ãƒˆ2','è¿½åŠ ãƒ†ã‚¹ãƒˆ',20000,301,'ãƒ‘ãƒ–ãƒªãƒƒã‚·ãƒ¥','2024-03-08','aaaaaa','',0,24020801,'2024-03-18',24020801,'2024-03-18',NULL,NULL,NULL),('BK031306','è¿½åŠ ãƒ†ã‚¹ãƒˆï¼“','ã‚ã‚ã‚ã‚',2000,301,'ã‚ã‚ã‚ã‚','2024-03-08','æ›´æ–°ãƒ†ã‚¹ãƒˆ\r\naaaaaaaaaa\r\naaaaaaaaaa\r\naaaaaaaaaa\r\naaaaaaaaaa\r\naaaaaaaaaa\r\naaaaaaaaaa','',0,24020801,'2024-03-14',24032101,'2024-04-09',NULL,NULL,NULL);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-26 14:52:00
