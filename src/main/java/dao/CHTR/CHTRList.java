package dao.CHTR; /**
 * Created by Yury on 25.07.2015.
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "CHTRList")
@XmlAccessorType (XmlAccessType.FIELD)
public class CHTRList
{
    @XmlElement(name = "CHTR")
    private List<CHTR> CHTRList = null;

    public List<CHTR> getCHTRList() {
        return CHTRList;
    }

    public void setCHTRList(List<CHTR> CHTRList) {
        this.CHTRList = CHTRList;
    }

}