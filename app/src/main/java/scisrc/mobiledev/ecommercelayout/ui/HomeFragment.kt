package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import scisrc.mobiledev.ecommercelayout.R
import scisrc.mobiledev.ecommercelayout.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var productAdapter: ProductAdapter
    private lateinit var promoAdapter: ProductAdapter

    private val productList = mutableListOf<Product>()
    private val promoList = mutableListOf<Product>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 🔹 ตั้งค่า RecyclerView สำหรับสินค้าแนะนำ
        binding.recyclerViewProducts.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        productAdapter = ProductAdapter(productList)
        binding.recyclerViewProducts.adapter = productAdapter

        // 🔹 ตั้งค่า RecyclerView สำหรับโปรโมชั่น
        binding.recyclerViewPromos.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        promoAdapter = ProductAdapter(promoList)
        binding.recyclerViewPromos.adapter = promoAdapter

        // 🔹 โหลดข้อมูล
        loadProducts()
        loadPromotions()
    }

    private fun loadProducts() {
        productList.add(Product("หมีน้ำเงิน", "1390 บาท", R.drawable.darkblue))
        productList.add(Product("หมีบานเย็น", "1390 บาท", R.drawable.darkpink))
        productList.add(Product("หมีฟ้า", "1290 บาท", R.drawable.blue))
        productList.add(Product("หมีชมพู", "1290 บาท", R.drawable.pink))
        productAdapter.notifyDataSetChanged()
    }

    private fun loadPromotions() {
        promoList.add(Product("หมีน้ำเงิน", "ลดเหลือ 1300 บาท", R.drawable.darkblue))
        promoList.add(Product("หมีบานเย็น", "ลดเหลือ 1300 บาท", R.drawable.darkpink))
        promoList.add(Product("หมีฟ้า", "ลดเหลือ 1200 บาท", R.drawable.blue))
        promoList.add(Product("หมีชมพู", "ลดเหลือ 1200 บาท", R.drawable.pink))
        promoAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}