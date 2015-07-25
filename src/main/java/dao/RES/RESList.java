package dao.RES; /**
 * Created by Yury on 25.07.2015.
 */
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "RESList")
@XmlAccessorType (XmlAccessType.FIELD)
public class RESList
{
    @XmlElement(name = "RES")
    private List<RES> RESList = null;


    public List<RES> getRESList() {
        return RESList;
    }

    public void setResList(List<RES> resList) {
        this.RESList = resList;
    }

}